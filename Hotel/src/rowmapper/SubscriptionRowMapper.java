package rowmapper;

import java.sql.ResultSet;

import entity.Subscription;

import util.RowMapper;

public class SubscriptionRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs) throws Exception {
		Subscription subscription=new Subscription();
		subscription.setId(rs.getInt("id"));
		subscription.setMid(rs.getInt("mid"));
		subscription.setNo(rs.getString("no"));
		subscription.setLinkman(rs.getString("linkman"));
		subscription.setEmail(rs.getString("email"));
		subscription.setPhone(rs.getString("phone"));
		subscription.setStatus(rs.getString("status"));
		subscription.setRemark(rs.getString("remark"));
		subscription.setCretime(rs.getTimestamp("cretime"));
								
		return subscription;
	}

}
