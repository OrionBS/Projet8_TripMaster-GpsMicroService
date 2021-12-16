package com.tourguide.GpsMicroService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GpsIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetUserLocation() throws Exception {
        //GIVEN
        UUID userId = UUID.randomUUID();

        //WHEN
        mockMvc.perform(get("/getUserLocation")
                .param("userId", String.valueOf(userId)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //THEN

    }

    @Test
    public void testGetAttractions() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(get("/getAttractions"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //THEN
    }

}
