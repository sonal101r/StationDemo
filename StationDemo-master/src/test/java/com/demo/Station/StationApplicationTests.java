package com.demo.Station;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationApplicationTests {

	@Test
	public void applicationContextLoaded() {
	}

	@Test
	public void applicationContextTest() {
	    StationApplication.main(new String[] {});
	}
}
