package com.example.talktopi.domain.community.controller;

import com.example.talktopi.domain.community.controller.dto.request.CommunityRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CommunityControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void save() throws Exception{
        String content = "에베베베벱";

        CommunityRequest request = new CommunityRequest(content);
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/community")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NzA2NjE2MSwiZXhwIjoxNjc3MDY5NzYxfQ.6XIlUqaZI0zh8ARJX82Tzk491wuT9Ps1QACUPurkNFU")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}
