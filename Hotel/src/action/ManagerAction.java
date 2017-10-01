package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import entity.Manager;
import factory.ObjectFactory;

import service.ManagerService;

public class ManagerAction extends MappingDispatchAction{
	public ActionForward login(ActionMapping mapping, ActionForm form,	
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		ManagerService managerService=(ManagerService)ObjectFactory.getObject("managerService");
		Manager manager=managerService.login(username, password);
		request.getSession().setAttribute("manager",manager);
		return mapping.findForward("success");
	}
}
