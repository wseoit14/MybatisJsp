package com.example.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.example.config.SqlSessionConfig;
import com.example.dao.ExDAOimpl;
import com.example.vo.ExVO;

public class ExServiceImpl implements ExService{
	private static ExServiceImpl instance = new ExServiceImpl();
	private ExServiceImpl() {}
	public static ExServiceImpl getInstance() {
		return instance;
	}
	@Override
	public ExVO now() {
		SqlSession session = null;
		ExVO vo = null;
		try {
			session = SqlSessionConfig.getSqlSessionFactory().openSession();
			vo = ExDAOimpl.getInstance().now(session);
			session.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return vo;
	}
}
