package com.taashee.SpringWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taashee.SpringWebApp.entity.States;
import com.taashee.SpringWebApp.service.StateService;

@Controller
@RequestMapping("/")
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping(path="/state")
	public String getAllStates(ModelMap modelMap) {
		List<States>  states=stateService.findAll();
		modelMap.put("states", states);
		return "state-list";
		
	}

	@GetMapping(path ="/updateStatesForm")
	public String getUupdateStatesForm(@RequestParam int state_id,ModelMap modelMap) {
		States state=stateService.findByStateId(state_id);
		modelMap.put("state", state);
		return "add-a-state-form";
		
	}
	
	@PostMapping(path ="/updateStates")
	public String updateStatesForm(@RequestParam int state_id,
			@RequestParam String name,
			@RequestParam String abbrevation,
			@RequestParam int popultion,
			@RequestParam String capital ,ModelMap modelMap) {
		int rowsUpdated=stateService.update(new States(state_id,name,abbrevation,popultion,capital),state_id);
		return getAllStates(modelMap);
		
	}
	@GetMapping(path ="/addStateForm")
	public String getAddStateForm(ModelMap modelMap) {
		return "add-a-state-form";
		
	}
	
	@PostMapping(path ="/addState")
	public String addState(@RequestParam int state_id,
			@RequestParam String name,
			@RequestParam String abbrevation,
			@RequestParam int population,
			@RequestParam String capital ,ModelMap modelMap) {
		int rowsUpdated=stateService.insert(new States(state_id,name,abbrevation,population,capital));
		return getAllStates(modelMap);
		
	}
	@GetMapping(path ="/deleteStateForm")
	@PreAuthorize(value="hasRole('ADMIN')")
	public String deleteStateForm(@RequestParam int state_id,ModelMap modelMap) {
		int rowsDeleted=stateService.deleteByStateId(state_id);
		return getAllStates(modelMap);
	}
}

