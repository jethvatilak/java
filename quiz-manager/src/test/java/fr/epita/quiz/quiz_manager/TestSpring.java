package fr.epita.quiz.quiz_manager;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application.xml")
public class TestSpring {

	@Inject
	@Named("firstQuery")
	String query;
	
	@Test
	public void testInject() {
		Assert.assertNotNull(query);
	}
}
