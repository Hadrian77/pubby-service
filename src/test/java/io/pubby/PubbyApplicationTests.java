package io.pubby;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.pubby.repositories.PlayerRepository;
import io.pubby.repositories.SessionRepository;
import io.pubby.data.DataService;
import io.pubby.models.AnswerRecord;
import io.pubby.models.Player;
import io.pubby.models.Question;
import io.pubby.models.Session;

@SpringBootTest
class PubbyApplicationTests {

	
	@Autowired
	DataService dataService;
	
	
	
	@Test
	void dataServiceTest() {
		

		
	}

}
