package com.ricky.game.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ricky.game.domain.LoginUser;
import com.ricky.game.domain.sys.SysRanking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class RankingControllerTest extends BaseControllerTest {
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    Gson GSON = new GsonBuilder().create();

    String[] uri = {"/ranking/{page}"};
    MvcResult result;
    String body;

    @Test
    void testGetRanking() throws Exception{
        result = mvc.perform(MockMvcRequestBuilders.get(uri[0],"0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        body = result.getResponse().getContentAsString();
        System.out.println(body);
    }

    @Test
    void testPutRanking() throws Exception{
        SysRanking ranking = new SysRanking();
        ranking.setUserId(111L);
        ranking.setUserScore(111L);
        String requestBody = GSON.toJson(ranking);
        result = mvc.perform(MockMvcRequestBuilders.put("/ranking")
                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        body = result.getResponse().getContentAsString();
        System.out.println(body);
    }

}
