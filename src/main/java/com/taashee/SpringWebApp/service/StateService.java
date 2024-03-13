package com.taashee.SpringWebApp.service;

import java.util.List;

import com.taashee.SpringWebApp.dao.StatesDAO;
import com.taashee.SpringWebApp.entity.States;

public interface StateService {

	List<States> findAll();

	States findByStateId(int state_id);

	int deleteByStateId(int state_id);
	int update(States states, int state_id);
	int insert(States states);

	void setStateDao(StatesDAO stateDao);
}
