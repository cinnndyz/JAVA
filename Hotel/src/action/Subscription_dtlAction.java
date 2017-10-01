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

import service.SubscriptionService;
import service.Subscription_dtlService;

import entity.Room;
import entity.Subscription;
import entity.Subscription_dtl;
import factory.ObjectFactory;
import form.Subscription_dtlForm;

public class Subscription_dtlAction extends MappingDispatchAction{
	public ActionForward insertSession(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rootType= request.getParameter("rootType");
		String bookType=request.getParameter("bookType");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");	
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date());
		if(startDate==""||endDate==""){
			return mapping.findForward("fail");
		}				
		if(java.sql.Date.valueOf(date).after(java.sql.Date.valueOf(startDate))){
			return mapping.findForward("fail");
		}
		if(java.sql.Date.valueOf(startDate).after(java.sql.Date.valueOf(endDate))){
			return mapping.findForward("fail");
		}
		if(java.sql.Date.valueOf(date).after(java.sql.Date.valueOf(endDate))){
			return mapping.findForward("fail");
		}
		
		Subscription_dtl subscription_dtl=new Subscription_dtl();
		subscription_dtl.setSdate(sdf.parse(startDate));
		subscription_dtl.setEdate(sdf.parse(endDate));
		subscription_dtl.setResidetype(Integer.parseInt(bookType));
		subscription_dtl.setRid(Integer.parseInt(rootType));
		int day=(int)(sdf.parse(endDate).getTime()/1000/60/60/24-sdf.parse(startDate).getTime()/1000/60/60/24+1);
		if(day<0){
			return mapping.findForward("fail");
		}
		if(subscription_dtl.getRid()==1&&subscription_dtl.getResidetype()==1){
			subscription_dtl.setPrice((float)(day*50));
		}
		if(subscription_dtl.getRid()==1&&subscription_dtl.getResidetype()==2){
			subscription_dtl.setPrice((float)(day*80));
		}
		if(subscription_dtl.getRid()==2&&subscription_dtl.getResidetype()==1){
			subscription_dtl.setPrice((float)(day*100));
		}
		if(subscription_dtl.getRid()==2&&subscription_dtl.getResidetype()==2){
			subscription_dtl.setPrice((float)(day*160));
		}
		if(subscription_dtl.getRid()==3&&subscription_dtl.getResidetype()==1){
			subscription_dtl.setPrice((float)(day*150));
		}
		if(subscription_dtl.getRid()==3&&subscription_dtl.getResidetype()==2){
			subscription_dtl.setPrice((float)(day*260));
		}
		request.getSession().setAttribute("subscription_dtl",subscription_dtl);			

		Subscription_dtlService subscription_dtlService=(Subscription_dtlService)ObjectFactory.getObject("subscriptiondtlService");
		List<Room> rooms=subscription_dtlService.showroom(subscription_dtl);
		request.getSession().setAttribute("rooms",rooms);
		return mapping.findForward("insertSession");		
	}
	
	public ActionForward insert(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] str=request.getParameterValues("room");
		Subscription_dtl subscription_dtl=(Subscription_dtl)request.getSession().getAttribute("subscription_dtl");
		Integer id=(Integer)request.getSession().getAttribute("id");
		subscription_dtl.setPrice(subscription_dtl.getPrice());
		
		
		
		Subscription_dtlService subscription_dtlService=(Subscription_dtlService)ObjectFactory.getObject("subscriptiondtlService");	
		subscription_dtlService.insert(subscription_dtl,id,str);
		return mapping.findForward("insert");
	}
	
	public ActionForward remove(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("id");
		request.getSession().removeAttribute("subscription_dtl");
		request.getSession().removeAttribute("rooms");
		return mapping.findForward("remove");
	}
	
	public ActionForward show(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id=(Integer)request.getSession().getAttribute("id");
		
		Subscription_dtlService subscription_dtlService=(Subscription_dtlService)ObjectFactory.getObject("subscriptiondtlService");	
		List<Subscription_dtl> Subscription_dtls=subscription_dtlService.show(id);
		request.getSession().setAttribute("Subscription_dtls", Subscription_dtls);
		return mapping.findForward("show");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		//System.out.println(1+" "+id);
		Subscription_dtlService subscription_dtlService=(Subscription_dtlService)ObjectFactory.getObject("subscriptiondtlService");
		subscription_dtlService.delete(id);
		return mapping.findForward("delete");
	}
}
