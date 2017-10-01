package form;

import org.apache.struts.action.ActionForm;

import entity.Subscription_dtl;

public class Subscription_dtlForm extends ActionForm{
	private Subscription_dtl subscription_dtl=new Subscription_dtl();

	public Subscription_dtl getSubscription_dtl() {
		return subscription_dtl;
	}

	public void setSubscription_dtl(Subscription_dtl subscriptionDtl) {
		subscription_dtl = subscriptionDtl;
	}
	
}
