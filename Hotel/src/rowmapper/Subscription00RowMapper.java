package rowmapper;

import java.sql.ResultSet;

import entity.Subscription;

import util.RowMapper;

public class Subscription00RowMapper implements RowMapper{

	public Object mapRow(ResultSet rs) throws Exception {
		Subscription subscription=new Subscription();
		subscription.setId(rs.getInt("id"));
		subscription.setMid(rs.getInt("mid"));
		subscription.setNo(rs.getString("no"));
		subscription.setLinkman(rs.getString("linkman"));
		subscription.setEmail(rs.getString("email"));
		subscription.setPhone(rs.getString("phone"));
		subscription.setStatus(rs.getString("status"));


								
		return subscription;
	}

}
