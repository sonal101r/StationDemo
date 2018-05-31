package com.demo.Station;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.Station.controller.StationController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(StationController.class)
public class StationControllerTest {

	
	 @Autowired
     private MockMvc mockMvc;
	 
	 @Autowired
	 private WebApplicationContext wac;

	 
	 @Before
	    public void setup () {
	        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	        this.mockMvc = builder.build();
	    }

	    @Test
	    public void testUserController () throws Exception {
	        ResultMatcher ok = MockMvcResultMatchers.status()
	                                                .isOk();

	        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/customers");
	        this.mockMvc.perform(builder)
	                    .andExpect(ok);

	    }
//
//     @Test
//     public void testSayHelloWorld() throws Exception {
//         this.mockMvc.perform(get("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType("application/json"));
//
//     }

	
}
