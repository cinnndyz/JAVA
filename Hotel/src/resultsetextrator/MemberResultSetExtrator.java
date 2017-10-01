package resultsetextrator;

import java.sql.ResultSet;

import entity.Member;

import util.ResultSetExtractor;

public class MemberResultSetExtrator implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws Exception {
		Member member=null;
		if(rs.next()){
			member=new Member();
			member.setUsername(rs.getString("username"));
			member.setPwd(rs.getString("pwd"));
			member.setName(rs.getString("name"));
			member.setEmail(rs.getString("email"));
			member.setPhone(rs.getString("phone"));			
		}
		return member;
	}

}
