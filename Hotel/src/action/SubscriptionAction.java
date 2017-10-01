package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import service.SubscriptionService;

import entity.Member;
import entity.Subscription;
import entity.Subscription_dtl;
import factory.ObjectFactory;
import form.MemberForm;
import form.SubscriptionForm;

public class SubscriptionAction extends MappingDispatchAction{
	public ActionForward regist(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubscriptionForm subscriptionForm=(SubscriptionForm)form;
		SubscriptionService subscriptionService=(SubscriptionService)ObjectFactory.getObject("subscriptionService");
		subscriptionService.regist(subscriptionForm.getSubscription());
		return mapping.findForward("success");
	}
	
	public ActionForward show(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member=(Member)request.getSession().getAttribute("member");
		
		SubscriptionService subscriptionService=(SubscriptionService)ObjectFactory.getObject("subscriptionService");
		
		List<Subscription> subscriptions=subscriptionService.show(member.getId());
		request.setAttribute("subscriptions",subscriptions);
		return mapping.findForward("success01");		
	}
	
	public ActionForward showmessage(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		request.getSession().setAttribute("id",id);
		
		SubscriptionService subscriptionService=(SubscriptionService)ObjectFactory.getObject("subscriptionService");
		List<Subscription>  subscriptions=subscriptionService.showmessage(id);
		request.setAttribute("subscriptions02",subscriptions);
		
		return mapping.findForward("success02");
	}
	
	public ActionForward modifymessage(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubscriptionForm subscriptionForm=(SubscriptionForm)form;
		SubscriptionService subscriptionService=(SubscriptionService)ObjectFactory.getObject("subscriptionService");
		
		subscriptionService.modifymessage(subscriptionForm.getSubscription());
		return mapping.findForward("success03");
	}
	
	public ActionForward id(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id=Integer.parseInt(request.getParameter("id"));		
		request.getSession().setAttribute("id",id);		
		return mapping.findForward("id");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		SubscriptionService subscriptionService=(SubscriptionService)ObjectFactory.getObject("subscriptionService");
		List<Subscription_dtl> Subscription_dtls=subscriptionService.select(id);
		if(Subscription_dtls.size()!=0){
			return mapping.findForward("fail");
		}
		
		subscriptionService.delete(id);
		return mapping.findForward("success04");
	}
	public ActionForward showhistory(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member=(Member)request.getSession().getAttribute("member");
		
		SubscriptionService subscriptionService=(SubscriptionService)ObjectFactory.getObject("subscriptionService");
		
		List<Subscription> subscriptions=subscriptionService.showhistory(member.getId());
		request.setAttribute("subscriptions",subscriptions);
		return mapping.findForward("success05");		
	}
}
