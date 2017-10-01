package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import entity.Product;
import util.jdbcUtil;

public class ProductAction extends MappingDispatchAction{
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	/*	ProductForm productForm=(ProductForm) form;
		Product product=productForm.getProduct();
		
		Integer id=product.getId();
		String name=product.getName();
		Double price=product.getPrice();
		*/
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Product> products=new ArrayList<Product>();
		try {
			con=jdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
							.append("select * from t_product ")
							.toString();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			
			while(rs.next()){
				Integer id=rs.getInt("id");
				String name=rs.getString("name");
				Double price=rs.getDouble("price");
				
				Product product=new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				
				products.add(product);
			}
			con.commit();
			
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
		//将查询的商品信息保存到request中
		request.setAttribute("products", products);
		//转发到list.jsp做显示
		/*System.out.println("111");*/
		return mapping.findForward("success");
	}
}
