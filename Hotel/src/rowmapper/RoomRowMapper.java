package rowmapper;

import java.sql.ResultSet;

import entity.Room;

import util.RowMapper;

public class RoomRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs) throws Exception {
		Room room=new Room();
		room.setId(rs.getInt("id"));
		room.setCid(rs.getInt("cid"));
		room.setNo(rs.getString("no"));
		room.setStatus(rs.getString("status"));
		return room;
	}

}
