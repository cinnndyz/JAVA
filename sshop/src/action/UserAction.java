package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import util.jdbcUtil;

import entity.Cart;
import entity.User;

public class UserAction extends MappingDispatchAction {
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	/*	UserForm userForm=(UserForm) form;
		User user=userForm.getUser();
		//获取
		String username=user.getUsername();
		String password=user.getPassword();*/
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//连接
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=jdbcUtil.getConnection();
		
		try {
			con.setAutoCommit(false);
			String sql=new StringBuffer()
							.append("select * from t_user ")
							.append("where username=? and password=? ")
							.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			//根据输入内容 在数据库中筛选并判断 
			if(rs.next()){
				Integer id=rs.getInt("id");
				String ph=rs.getString("phone");
				String add=rs.getString("address");//获得三个结果 创建User对象 并赋值
				User user1=new User();//添加实体类
				user1.setId(id);
				user1.setUsername(username);
				user1.setPhone(ph);
				user1.setAddress(add);
				//将用户保存到session中
				HttpSession session=request.getSession();
				session.setAttribute("user", user1);
				//创建一个新的购物车保存到session中
				session.setAttribute("cart", new Cart());
				con.commit();
				//登陆成功跳转 商品列表
				/*response.sendRedirect(request.getContextPath()+"/list.product");*/
				System.out.println("111");
				return mapping.findForward("success");
			}else{
				//如果没有结果集 说明用户名密码不正确
				request.setAttribute("message", "用户名密码不正确");
			/*	request.getRequestDispatcher("/shop/login.jsp").forward(request,response);*/
				return mapping.findForward("fail");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			jdbcUtil.close(con,ps,rs);
		}
		return null;
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//销毁session
		request.getSession().invalidate();
		//重定向商品列表
		return mapping.findForward("success");
	}
	public ActionForward regist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//注册页面获取信息 并添加进数据库
		String name=request.getParameter("username");
		String psd=request.getParameter("password");
		String ph=request.getParameter("phone");
		String add=request.getParameter("address");
		
		//判断页面传过来验证码是否与session中的验证码相同，如果不相同 return
		
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=jdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			//判断用户名是否已经被注册
			String sql=new StringBuffer()
						.append("select *from t_user ")
						.append("where username=? ")
						.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1,name);//将用户名作比较
			rs=ps.executeQuery();
			
			if(rs.next()){
				request.setAttribute("message", "用户名被注册");
				con.commit();
				return mapping.findForward("fail");
			}
			//被注册跳转至的登陆界面
			//如果用户名没有被注册 则新增用户
			sql=new StringBuffer()//注意格式 空格
						.append("insert into t_user ")
						.append("       (username,password,phone,address) ")
						.append("values ")
						.append("      (?,?,?,?) ")
						.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1,name);//此处为定义的名称 不是数据库里的分类名称
			ps.setString(2,psd);
			ps.setString(3,ph);
			ps.setString(4,add);
			ps.executeUpdate();
			con.commit();
			//注册成功后跳转登陆界面
/*			response.sendRedirect(request.getContextPath()+"/shop/login.jsp");*///需要有login servlet
			return mapping.findForward("success");

			//完成数据库修改 重定向login列表
			
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
	
}
