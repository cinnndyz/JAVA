package form;

import org.apache.struts.action.ActionForm;

import entity.Subscription;

public class SubscriptionForm extends ActionForm{
	private Subscription subscription=new Subscription();

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	} 
	
}
