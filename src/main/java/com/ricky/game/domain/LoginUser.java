package com.ricky.game.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {
    @JsonProperty("userId")
    Long userId;
    @JsonProperty("userName")
    String userName;
    @JsonProperty("userPassword")
    String userPassword;
}
