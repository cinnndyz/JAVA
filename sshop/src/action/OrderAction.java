package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import entity.Cart;
import entity.Item;
import entity.User;
import entity.Order;
import entity.Product;
import util.jdbcUtil;

import com.mysql.jdbc.Statement;

public class OrderAction extends MappingDispatchAction{
	
/**生成订单*/
	public ActionForward create(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		Cart cart=(Cart)session.getAttribute("cart");
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String no=getNo();
		con=jdbcUtil.getConnection();
		try {
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
						.append("insert into shop.t_order ")
						.append("       (no,user_id,createTime,price) ")
						.append("values ")
						.append("       (?,?,?,?) ")
						.toString();
		ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//
		ps.setString(1, no);
		ps.setInt(2, user.getId());
		ps.setTimestamp(3, new Timestamp(new Date().getTime()));
		ps.setDouble(4, cart.getPrice());
		ps.executeUpdate();
		
		rs=ps.getGeneratedKeys();
		Integer id=null;
		if(rs.next()){
			id=rs.getInt(1);
		}
		sql=new StringBuffer()
				.append("insert into shop.t_item ")
				.append("       (product_id,num,price,order_id) ")
				.append("values ")
				.append("       (?,?,?,?) ")
				.toString();
	ps=con.prepareStatement(sql);
	List<Item> items=cart.getItems();
	
	for(Item item:items){
		ps.setInt(1, item.getProduct().getId());
		ps.setInt(2, item.getNum());
		ps.setDouble(3, item.getPrice());
		ps.setInt(4, id);
		ps.executeUpdate();
	}
	con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			jdbcUtil.close(con, ps, rs);
		}
		session.setAttribute("cart", new Cart());
		session.setAttribute("no", no);
		/*response.sendRedirect(request.getContextPath()+"/shop/success.jsp?no="+no);
		return null;*/
		return mapping.findForward("success");
	}
	
	/**显示所有订单*/
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user=(User)request.getSession().getAttribute("user");
		Integer userId=user.getId();

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Order> orders=new ArrayList<Order>();
		
		con=jdbcUtil.getConnection();
		try {
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
							.append("select * from t_order ")
							.append("where user_id=? ")
							.append("order by createTime desc ")
							.toString();
				ps=con.prepareStatement(sql);
				ps.setInt(1, userId);
				rs=ps.executeQuery();
				while(rs.next()){
				Integer id=rs.getInt("id");
				String no=rs.getString("no");
				
				
				Order order=new Order();
				order.setId(id);
				order.setCreateTime(rs.getTimestamp("createTime"));
				order.setNo(no);
				orders.add(order);
			}
				con.commit();
				
				request.setAttribute("orders", orders);
				/*request.getRequestDispatcher("/shop/orderList.jsp").forward(request, response);*/
				return mapping.findForward("success");
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally{
				jdbcUtil.close(con, ps, rs);
			}
		}
		return null;
	}
	
	
	/**显示订单详情*/
	public ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String no=request.getParameter("no");//获取页面值 no 订单号
		User u=(User)request.getSession().getAttribute("user");//获取session中user的信息
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Order order=null;//???
		
		con=jdbcUtil.getConnection();
		try {
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
						.append("select ")
						.append("o.no,o.price oprice,u.username,i.num,i.price iprice,p.name, ")
						.append("(select count(1) from t_item where order_id=o.id) count ")
						.append("from shop.t_order o ")
						.append("left join shop.t_user u on o.user_id=u.id ")
						.append("left join shop.t_item i on i.order_id=o.id ")
						.append("left join shop.t_product p on p.id=i.product_id ")
						.append("where o.no=? ")
						.append("and o.user_id=? ")
						.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1,no);
			ps.setInt(2,u.getId());
			rs=ps.executeQuery();
			
			while(rs.next()){
				if(order==null){
					order=new Order();
					User user=new User();
					user.setUsername(rs.getString("u.username"));
					order.setUser(user);
					order.setNo(rs.getString("o.no"));
					order.setCount(rs.getInt("count"));
					order.setPrice(rs.getDouble("oprice"));
				}
				Item item=new Item();
				Product product=new Product();
				product.setName(rs.getString("p.name"));
				item.setProduct(product);
				item.setNum(rs.getInt("i.num"));
				item.setPrice(rs.getDouble("iprice"));
				
				order.setItems(item);
			}
			con.commit();
			
			request.setAttribute("order", order);
			/*request.getRequestDispatcher("/shop/orderDetail.jsp").forward(request, response);*/
			return mapping.findForward("success");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			jdbcUtil.close(con, ps, rs);
		}
		return null;
	}
/**删除订单*/
	public ActionForward remove(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer id=Integer.parseInt(request.getParameter("id"));//???
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=jdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
							.append("delete from t_item ")
							.append("where order_id=? ")
							.toString();
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			sql=new StringBuffer()
						.append("delete from shop.t_order ")
						.append("where id=? ")
						.toString();
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			con.commit();
			
			/*response.sendRedirect(request.getContextPath()+"/list.order");*/
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			jdbcUtil.close(con, ps, rs);
		}
		return null;
	}
	
	public synchronized String getNo(){
		Random r=new Random();
		Integer i=r.nextInt(10000);
		return new Date().getTime()+i.toString();
	}
}
