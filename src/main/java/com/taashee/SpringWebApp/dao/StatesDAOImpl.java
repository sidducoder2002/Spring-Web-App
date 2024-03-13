package com.taashee.SpringWebApp.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taashee.SpringWebApp.entity.States;

@Repository
public class StatesDAOImpl implements StatesDAO {
	private static final String getAllStates="SELECT * FROM states";
	private static final String addStateQuery= "Insert into states (state_id,state_name,abbreviation,population,capital) "
			+ "values(?,?,?,?,?)";
	private static final String deleteStateByIdQuery = "delete from states where state_id = ?";
	private static final String updateStateQeury = "update states set state_name = ? ,abbreviation =? ,population = ?, capital = ? "
			+ "where state_id= ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<States> findAll() {
		return  jdbcTemplate.query(getAllStates, new StateRowMapper());
		
	}


	@Override
	public States findByStateId(int state_id) {
		
		return jdbcTemplate.queryForObject("SELECT * FROM states WHERE state_id = ?",
	            new StateRowMapper(), state_id);
	}
	@Override
	public int insert(States states) {
		
		return jdbcTemplate.update(addStateQuery,new Object[]{states.getState_id(),
				states.getName(),states.getAbbrevation(),states.getPopultion()
				,states.getCapital()});
	}	

	@Override
	public int deleteByStateId(int state_id) {
		
		return jdbcTemplate.update(deleteStateByIdQuery,new Object[]{state_id});
	}


	@Override
	public int update(States states, int state_id) {
		
		return jdbcTemplate.update(updateStateQeury,new Object[]{
				states.getName(),states.getAbbrevation(),states.getPopultion()
				,states.getCapital(),states.getState_id()});
	}


	
}
