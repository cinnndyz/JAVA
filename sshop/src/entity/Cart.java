package entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.jdbcUtil;



public class Cart implements Serializable{
	private List<Item> items=new ArrayList<Item>();
	private Double price=0.0;
	public Cart() {
	}
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	//根据商品id添加购物车
	public void addCart(Integer productId){
		//根据商品ID查询当前商品的所有信息
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Product product=new Product();
		
		con=jdbcUtil.getConnection();
		try {
			con.setAutoCommit(false);//手动更新
			
			String sql=new StringBuffer()
						.append("select*from shop.t_product ")
						.append("where id=? ")
						.toString();
			ps=con.prepareStatement(sql);
			ps.setInt(1, productId);
			rs=ps.executeQuery();
			
			if(rs.next()){
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			jdbcUtil.close(con, ps, rs);
		}
		//购物车总价格
		price=price+product.getPrice();
		//判断购物车已存在此商品，只需修改当前商品的数量和价格
		for(Item item:items){
			if(productId==item.getProduct().getId()){
				//数量价格
				item.setNum(item.getNum()+1);
				item.setPrice(item.getNum()*product.getPrice());
				return;
			}
		}
		//将查询出的商品对象添加到购物车
		Item item=new Item();
		item.setProduct(product);
		item.setNum(1);
		item.setPrice(product.getPrice());
		items.add(item);
		
	}
	//根据商品ID删除对应商品
	public void removeCartByProductId(Integer productId){
	
		for(int i=0;i<items.size();i++){//遍历集合 获取商品ID 并调整删减商品后的价格
			Item item=items.get(i);
			if(productId==item.getProduct().getId()){
				price-=item.getPrice();
				items.remove(i);//减价 并移除
			}
		}
	}
	//根据商品id和数量修改对应商品信息
	public void modifyCartByProductIdNum(Integer productId,Integer num){
		for(Item item:items){//数据类型 数据名:元素 
			if(productId==item.getProduct().getId()){
				price-=item.getPrice();
				item.setNum(num);
				item.setPrice(num*item.getProduct().getPrice());
				price+=item.getPrice();
			}
		}
	}
	
	//根据商品多个id删除对应商品
	public void removeCartByProductIds(String[] productIds){
		for(int i=0;i<productIds.length;i++){
			removeCartByProductId(Integer.parseInt(productIds[i]));
		}
	}
	
	//清空购物车 Set<Item> items从新定义 price=0.0
	public void clearCart(){
		items=new ArrayList<Item>();
		price=0.0;
	}

}
