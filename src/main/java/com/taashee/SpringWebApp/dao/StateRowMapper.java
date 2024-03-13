package com.taashee.SpringWebApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.taashee.SpringWebApp.entity.States;

public class StateRowMapper implements RowMapper<States> {

	@Override
	public States mapRow(ResultSet rs, int rowNum) throws SQLException {
		States states=new States(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
		return states;
	}
	
}
