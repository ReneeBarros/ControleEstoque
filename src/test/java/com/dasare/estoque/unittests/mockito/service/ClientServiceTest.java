package com.dasare.estoque.unittests.mockito.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dasare.estoque.service.ClientService;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
	

	
	@InjectMocks
	private ClientService service;
	

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testSaveClient() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByID() {
		fail("Not yet implemented");
	}

	@Test
	void testGetByName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllClient() {
		fail("Not yet implemented");
	}

	@Test
	void testUpDateClient() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteClient() {
		fail("Not yet implemented");
	}

}
