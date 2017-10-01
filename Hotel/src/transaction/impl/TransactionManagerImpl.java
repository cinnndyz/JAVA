package transaction.impl;

import java.sql.Connection;

import transaction.TransactionManager;
import util.JdbcUtil;
import exception.DataAccessException;

public class TransactionManagerImpl implements TransactionManager {

	public void beginTransaction() {
		Connection con=null;
		try {
			con=JdbcUtil.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
	}

	public void commit() {
		Connection con=null;
		try {
			con=JdbcUtil.getConnection();
			con.commit();
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		} finally {
			JdbcUtil.close();
		}
	}

	public void rollback() {
		Connection con=null;
		try {
			con=JdbcUtil.getConnection();
			con.rollback();
		} catch (Exception e) {
			//通知管理员，人为解决
		} finally {
			JdbcUtil.close();
		}			
	}

}