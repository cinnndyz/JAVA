package rowmapper;

import java.sql.ResultSet;

import entity.Member;

import util.RowMapper;

public class MemberRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs) throws Exception {
		Member member=new Member();
		member.setId(rs.getInt("id"));
		member.setUsername(rs.getString("username"));
		member.setPwd(rs.getString("pwd"));
		member.setName(rs.getString("name"));
		member.setEmail(rs.getString("email"));
		member.setPhone(rs.getString("phone"));
	
		
		return member;
	}

}
