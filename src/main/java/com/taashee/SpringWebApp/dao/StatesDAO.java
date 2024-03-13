package com.taashee.SpringWebApp.dao;

import java.util.List;

import com.taashee.SpringWebApp.entity.States;

public interface StatesDAO {

	List<States> findAll();

	States findByStateId(int state_id);

	int deleteByStateId(int state_id);
	int update(States states,int state_id);

	int insert(States states);

}
