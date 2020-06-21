package com.ricky.game.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {
    Long userId;
    String userName;
    String userPassword;
}
