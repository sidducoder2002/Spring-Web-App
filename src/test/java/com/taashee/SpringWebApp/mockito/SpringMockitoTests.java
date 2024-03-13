package com.taashee.SpringWebApp.mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taashee.SpringWebApp.dao.StatesDAO;
import com.taashee.SpringWebApp.dao.StatesDAOImpl;
import com.taashee.SpringWebApp.entity.States;
import com.taashee.SpringWebApp.service.StateServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SpringMockitoTests {
	@Mock
	StatesDAO stateDao;
	@InjectMocks
	StateServiceImpl stateServiceImpl;
	
	
	@Test
	void testFindAll() {
		StatesDAO stateDao=new StatesDAOImpl();
		when(stateDao.findAll()).thenReturn(Arrays.asList(new States(1,"Telangana","TS",234243,"Hyderabad")));
		assertTrue(stateServiceImpl.findAll().size()>0);
	}
}
