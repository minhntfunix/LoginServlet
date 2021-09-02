package model;

import java.util.ArrayList;
import java.util.List;
//chứa info về 1 đơn hàng hiện tại
public class Cart {
	private List<Product> items; //list of item in cart
	
	public Cart() {
		items= new ArrayList<>();
	}
	
	//add a new product to cart
	
	public void add(Product ci) {  //(ci=cart items)
		for (Product x:items) {
			if (ci.getId() == x.getId()) {
				x.setNumber(x.getNumber() +1);
				return;
			}
		}
		items.add(ci); //add items to cart list
	}
	
	
	//remove a product from cart
	
	public void remove(int id) {
		for (Product x:items) {
			if (x.getId() == id) {
				items.remove(x);
				return;
			}
		}
	}
	
	//return total amount for cart
	
	public double getAmount() {
		double s=0;
		for (Product x:items){
			s+=x.getPrice()  * x.getNumber();
		}
		
		return Math.round(s*100.0)/100.0;
		
	}
	
	
	//return list of products in cart
	
	public List<Product> getitems(){
		return items;
		
	}
	
	
	public Product getProduct(int id) {  //(ci=cart items)
		for (Product x:items) {
			if (x.getId() == id) {
				return x;
				
			}
		}
		return null;
	}
	
}
