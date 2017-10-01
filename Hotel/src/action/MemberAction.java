package action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import service.MemberService;

import entity.Member;
import factory.ObjectFactory;
import form.MemberForm;

public class MemberAction extends MappingDispatchAction{
	public ActionForward regist(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberForm memberForm=(MemberForm)form;
		MemberService memberService=(MemberService)ObjectFactory.getObject("memberService");
		memberService.regist(memberForm.getMember());
		return mapping.findForward("success");
	}
	
	public ActionForward login(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		MemberService memberService=(MemberService)ObjectFactory.getObject("memberService");
		Member member=memberService.login(username, password);
		request.getSession().setAttribute("member", member);
		return mapping.findForward("success");
	}
	
}
