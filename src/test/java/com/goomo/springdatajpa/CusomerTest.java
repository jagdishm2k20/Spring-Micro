package com.goomo.springdatajpa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goomo.springdatajpa.dto.CustomerDTO;
import com.goomo.springdatajpa.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringDataJpaApplication.class})
@WebAppConfiguration
public class CusomerTest {

    @Autowired
    private WebApplicationContext ctx;

    private ObjectMapper mapper;


    private MockMvc mockMvc;

    CustomerDTO customerDTO;
    private final String cityURL = "/customer/saveCustomer";

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        mapper = new ObjectMapper();
         customerDTO=new CustomerDTO();
    }

    @Test
    public void testCityDetailsSuccess() throws Exception {

    	customerDTO.setFirstname("Rajesh");
    	customerDTO.setLastname("pulavarthy");
    	String str = mapper.writeValueAsString(customerDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(cityURL)
                .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8).content(str))
                .andReturn();
        Customer custResult = mapper.readValue(result.getResponse().getContentAsString(),Customer.class);
        assertNotNull(custResult);
    }

}
