package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.vo.ExVO;

public class ExJdbcDAOImpl implements ExJdbcDAO{
	private static ExJdbcDAOImpl instance = new ExJdbcDAOImpl();
	private ExJdbcDAOImpl() {}
	public static ExJdbcDAOImpl getInstance() {
		return instance;
	}
	@Override
	public ExVO now(Connection conn) throws SQLException {
		String query = "select now() now";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		ExVO vo = new ExVO();
		vo.setNow(rs.getString("now"));
		return vo;
	}
	
	
}
