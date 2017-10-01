package resultsetextrator;

import java.sql.ResultSet;

import entity.Subscription_dtl;

import util.ResultSetExtractor;

public class Subscription_dtlResultSetExtrator implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws Exception {
		Subscription_dtl subscription_dtl=null;
		if(rs.next()){
			subscription_dtl=new Subscription_dtl();
			subscription_dtl.setId(rs.getInt("id"));
			subscription_dtl.setRid(rs.getInt("rid"));
			subscription_dtl.setSid(rs.getInt("sid"));
			subscription_dtl.setSdate(rs.getDate("sdate"));
			subscription_dtl.setEdate(rs.getDate("edate"));
			subscription_dtl.setResidetype(rs.getInt("residetype"));
			subscription_dtl.setPrice(rs.getFloat("price"));
		}
		return subscription_dtl;
	}

}
