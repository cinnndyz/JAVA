package rowmapper;

import java.sql.ResultSet;

import entity.Subscription_dtl;

import util.RowMapper;

public class Subscription_dtlRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs) throws Exception {
		Subscription_dtl subscription_dtl=new Subscription_dtl();
		subscription_dtl.setId(rs.getInt("id"));
		subscription_dtl.setRid(rs.getInt("rid"));
		subscription_dtl.setSid(rs.getInt("sid"));
		subscription_dtl.setSdate(rs.getDate("sdate"));
		subscription_dtl.setEdate(rs.getDate("edate"));
		subscription_dtl.setResidetype(rs.getInt("residetype"));
		subscription_dtl.setPrice(rs.getFloat("price"));
		return subscription_dtl;
	}

}
