package com.ricky.game.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ricky.game.domain.LoginUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends BaseControllerTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    Gson GSON = new GsonBuilder().create();

    String[] uri = {"/toLogin", "/users/register", "/users/{id}"};
    MvcResult result;
    String body;

    @Test
    void testToLogin() throws Exception{
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(1003L); loginUser.setUserPassword("123456");
        String requestBody = GSON.toJson(loginUser);
        result = mvc.perform(MockMvcRequestBuilders.post("/toLogin")
                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //验证响应contentType
                .andReturn(); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        body = result.getResponse().getContentAsString();
        System.out.println(body);
    }


}
