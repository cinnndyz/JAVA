package form;

import org.apache.struts.action.ActionForm;

import entity.Product;

public class ProductForm extends ActionForm{
	private Product product=new Product();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
