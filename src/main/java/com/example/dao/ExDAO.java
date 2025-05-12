package com.example.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.example.vo.ExVO;

public interface ExDAO {
	ExVO now(SqlSession session)throws SQLException;
}
