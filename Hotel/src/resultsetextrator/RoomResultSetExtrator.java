package resultsetextrator;

import java.sql.ResultSet;

import entity.Room;

import util.ResultSetExtractor;

public class RoomResultSetExtrator implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws Exception {
		Room room=null;
		if(rs.next()){
			room=new Room();
			room.setId(rs.getInt("id"));
			room.setCid(rs.getInt("cid"));
			room.setNo(rs.getString("no"));
			room.setStatus(rs.getString("status"));
		}
		return room;
	}

}
