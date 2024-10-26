package com.jps.prj_singleton.controller;

import com.jps.prj_singleton.domain.Configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConfigurationController.class)
public class ConfigurationControllerUT {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void resetSingleton() {
        Configuration.resetInstance();
    }
    @Test
    public void testFirstInstanceCreated() throws Exception {
        mockMvc.perform(get("/check-instance"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("First instance created.")));
    }
}