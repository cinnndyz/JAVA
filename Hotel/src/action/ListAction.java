package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import service.ListService;
import service.SubscriptionService;
import service.Subscription_dtlService;

import entity.Member;
import entity.Subscription;
import entity.Subscription_dtl;
import factory.ObjectFactory;

public class ListAction extends MappingDispatchAction{
	public ActionForward SubscriptionList(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer rootType=Integer.parseInt(request.getParameter("rootType"));
		String status=request.getParameter("status");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");				
		String no=request.getParameter("no");
		String username=request.getParameter("username");
		//System.out.println(rootType+" "+status+" "+startDate+" "+endDate+" "+no+" "+username);
		ListService listService=(ListService)ObjectFactory.getObject("listService");
		List<Subscription> Subscriptions=listService.list(rootType,status,startDate,endDate,no,username);
		//System.out.println(Subscriptions.size());
		request.getSession().setAttribute("Subscriptions", Subscriptions);
		
		return mapping.findForward("SubscriptionList");	
	}
	
	public ActionForward SubscriptionDetail(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer id=Integer.parseInt(request.getParameter("id"));	
		Integer mid=Integer.parseInt(request.getParameter("mid"));		
		ListService listService=(ListService)ObjectFactory.getObject("listService");
		Subscription Subscription=listService.select(id);
		Member Member=listService.selectMemeber(mid);
		List<Subscription_dtl> Subscription_dtls=listService.selectSubscription_dtl(id);
		request.getSession().setAttribute("Member", Member);
		request.getSession().setAttribute("Subscription", Subscription);
		request.getSession().setAttribute("Subscription_dtls", Subscription_dtls);
		return mapping.findForward("SubscriptionDetail");
	}
	
	public ActionForward SubscriptionDetailUpdate(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Subscription subscription=(Subscription)request.getSession().getAttribute("Subscription");
		String status=request.getParameter("status");
		String str=request.getParameter("remark");
		
		ListService listService=(ListService)ObjectFactory.getObject("listService");
		listService.update(subscription.getId(),status,str);
		
		Subscription_dtlService subscription_dtlService=(Subscription_dtlService)ObjectFactory.getObject("subscriptiondtlService");
		if(status.equals("3")){			
			List<Subscription_dtl> Subscription_dtls=listService.selectId(subscription.getId());
			for (Subscription_dtl subscriptionDtl : Subscription_dtls) {
				subscription_dtlService.delete(subscriptionDtl.getId());
			}
						
		}
		return mapping.findForward("SubscriptionDetailUpdate");		
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id=Integer.parseInt(request.getParameter("id"));
		Subscription_dtlService subscription_dtlService=(Subscription_dtlService)ObjectFactory.getObject("subscriptiondtlService");
		subscription_dtlService.delete(id);
		return mapping.findForward("delete");
	}
	
	public ActionForward delete01(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		SubscriptionService subscriptionService=(SubscriptionService)ObjectFactory.getObject("subscriptionService");
		List<Subscription_dtl> Subscription_dtls=subscriptionService.select(id);
				
		subscriptionService.delete(id);
		return mapping.findForward("delete01");
	}
	
}
