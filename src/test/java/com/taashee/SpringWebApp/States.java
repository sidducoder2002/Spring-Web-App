package com.taashee.SpringWebApp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name= "states")
public class States {
	@Id
	private int state_id;
	private String name;
	private String abbreviation;
	private int popultion;
	private String capital;


	public int getState_id() {
		return state_id;
	}

	@Override
	public String toString() {
		return "States [state_id = " + state_id + ", name= " + name + ", abbrevation = " + abbreviation
				+ ", popultion = " + popultion + ", capital = " + capital + "]";
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public States() {
		super();
		// TODO Auto-generated constructor stub
	}

	public States(int state_id, String name, String abbrevation, int popultion, String capital) {
		super();
		this.state_id = state_id;
		this.name = name;
		this.abbreviation = abbrevation;
		this.popultion = popultion;
		this.capital = capital;
	}

	public String getAbbrevation() {
		return abbreviation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbreviation = abbrevation;
	}

	public int getPopultion() {
		return popultion;
	}

	public void setPopultion(int popultion) {
		this.popultion = popultion;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
}
