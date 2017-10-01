package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import service.ModifyService;
import util.JSONUtil;
import util.MD5Util;
import vo.AjaxResult;

import entity.Member;
import exception.DuplicateUsernameException;

import factory.ObjectFactory;
import form.MemberForm;

public class ModifyAction extends MappingDispatchAction{
	public ActionForward modify(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberForm memberForm=(MemberForm)form;		
		ModifyService modifyService=(ModifyService)ObjectFactory.getObject("modifyService");
		modifyService.modify(memberForm.getMember());
		
		return mapping.findForward("success");
	}
	
	public ActionForward pwd(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();

		String pwd = request.getParameter("pwd");
		String password = MD5Util.md5(pwd);

		Member member = (Member) request.getSession().getAttribute("member");

		AjaxResult ajaxResult = new AjaxResult();
		boolean a = member.getPwd().equals(password);

		if (a == true) {
			ajaxResult.setName("success");
			ajaxResult.setData("密码正确");
		} else {
			ajaxResult.setName("fail");
			ajaxResult.setData("密码错误");
		}
		out.print(JSONUtil.toJson(ajaxResult));
		return null;
	}
	
	public ActionForward modifyPwd(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberForm memberForm=(MemberForm)form;
		String pwd=memberForm.getMember().getPwd();
		
		Integer id=memberForm.getMember().getId();
		
		System.out.println(1+" "+id+" "+pwd);
		ModifyService modifyService=(ModifyService)ObjectFactory.getObject("modifyService");
		modifyService.modifyPwd(memberForm.getMember());
		return mapping.findForward("success");		
	}
	
}
