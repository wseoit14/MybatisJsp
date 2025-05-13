package com.example.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.config.JdbcConnection;
import com.example.dao.ExJdbcDAOImpl;
import com.example.vo.ExVO;

public class ExJdbcServiceImpl implements ExJdbcService{
	private static ExJdbcServiceImpl instance = new ExJdbcServiceImpl();
	private ExJdbcServiceImpl() {}
	public static ExJdbcServiceImpl getInstance() {
		return instance;
	}
	@Override
	public ExVO now() {
		Connection conn = null;
		ExVO vo = null;
		try {
			conn = JdbcConnection.getConnection();
			conn.setAutoCommit(false);
			vo = ExJdbcDAOImpl.getInstance().now(conn);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcConnection.rollback(conn);
		} finally {
			JdbcConnection.close(conn);
		}
		return vo;
	}
}
