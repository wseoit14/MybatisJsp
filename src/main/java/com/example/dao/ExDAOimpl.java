package com.example.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.example.vo.ExVO;

public class ExDAOimpl implements ExDAO{
	private static ExDAOimpl instance = new ExDAOimpl();
	private ExDAOimpl() {}
	public static ExDAOimpl getInstance() {
		return instance;
	}
	@Override
	public ExVO now(SqlSession session) throws SQLException {
		return session.selectOne("ExDAO.now");
	}
}
