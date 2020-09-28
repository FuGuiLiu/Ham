package com.sky.ham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TxUser {
    private Integer USER_ID;

    private String USERNAME;

    private String PASSWORD;

    private String QQ;

    private String EMAIL;

    private String NICK;

    private String TEL;

    private Date REG_TIME;

}