package com.hepexta.activemqpublisher.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PublisherRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenUrl_whenPostAddToQueue_thenFindPostResponse()
            throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post("/messages/addToQueue")
                .contentType(APPLICATION_JSON_VALUE)
                .content("{\"message\": \"hello world\"}");
        ResultMatcher contentMatcher = MockMvcResultMatchers.content()
                .string("POST Response");

        this.mockMvc.perform(builder).andExpect(contentMatcher)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void givenUrl_whenPostAddToTopic_thenFindPostResponse()
            throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post("/messages/addToTopic")
                .contentType(APPLICATION_JSON_VALUE)
                .content("{\"message\": \"hello world\"}");
        ResultMatcher contentMatcher = MockMvcResultMatchers.content()
                .string("POST Response");

        this.mockMvc.perform(builder).andExpect(contentMatcher)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}