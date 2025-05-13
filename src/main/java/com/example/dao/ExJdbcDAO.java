package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.vo.ExVO;

public interface ExJdbcDAO {
	ExVO now(Connection conn)throws SQLException;
}
