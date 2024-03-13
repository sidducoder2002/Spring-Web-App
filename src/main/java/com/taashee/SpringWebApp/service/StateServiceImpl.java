package com.taashee.SpringWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringWebApp.dao.StateRepository;
import com.taashee.SpringWebApp.dao.StatesDAO;
import com.taashee.SpringWebApp.entity.States;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	//private StatesDAO statesdaos;
	private StateRepository statesdao;
	
	@Override
	public List<States> findAll() {
		return statesdao.findAll();
	}

	@Override
	public States findByStateId(int state_id) {
		
		//return statesdao.findByStateId(state_id);
		return statesdao.findById(state_id).get();
	}

	@Override
	public int insert(States states) {
//		return statesdao.insert(states);
		statesdao.save(states);
		return 1;
	}
	@Override
	public int deleteByStateId(int state_id) {
	
		//return statesdao.deleteByStateId(state_id);
		statesdao.deleteById(state_id);
		return 1;
	}

	@Override
	public int update(States states,int state_id) {
//		return statesdao.update(states, state_id);
		states.setState_id(state_id);
		statesdao.save(states);
		return 1;
		
		
	}

	@Override
	public void setStateDao(StatesDAO stateDao) {
		
		this.statesdao=(StateRepository) stateDao;
	}


	 

	

}
