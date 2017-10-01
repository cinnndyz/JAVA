package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import entity.Cart;
import entity.User;

public class CartAction extends MappingDispatchAction{
	
	
/**查看购物车 判断是否登陆*/
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user=(User)request.getSession().getAttribute("user");
		//如果用户没有登录，到登录页面
		if(user==null){
			return mapping.findForward("fail");
		}
		//如果用户登录了，到我的购物车页面
		/*response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");
		return null;*/
		return mapping.findForward("success");
	}

/** 加入购物车*/
	public ActionForward add(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		Integer productId=Integer.parseInt(request.getParameter("productId"));
		//通过session获得当前用户的购物车
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		//根据商品的id添加购物车
		cart.addCart(productId);
		//重定向回商品列表页面
		/*response.sendRedirect(request.getContextPath()+"/list.product");*/
		return mapping.findForward("success");
		}


/**根据商品id删除购物车中对应商品*/
	public ActionForward removeByProductId(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer productId=Integer.parseInt(request.getParameter("productId"));
		//通过session获得当前用户的购物车
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.removeCartByProductId(productId);
		/*response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");*/
		return mapping.findForward("success");
		}
	
/**删除选中项*/
	public ActionForward removeByProductIds(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		String[] productIds=request.getParameterValues("productId");
		System.out.println(productIds);
		//通过session获得当前用户的购物车
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.removeCartByProductIds(productIds);
/*		response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");
*/	
		return mapping.findForward("success");
	}
	
/**清空购物车*/
	public ActionForward clear(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//通过session获得当前用户的购物车
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.clearCart();
	/*	response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");*/
		return mapping.findForward("success");
		}
	
	
/**修改商品数量*/
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer productId=Integer.parseInt(request.getParameter("productId"));
		Integer num=Integer.parseInt(request.getParameter("num"));
		//通过session获得当前用户的购物车
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.modifyCartByProductIdNum(productId, num);
	/*	response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");*/
		return mapping.findForward("success");
		}
	
}
