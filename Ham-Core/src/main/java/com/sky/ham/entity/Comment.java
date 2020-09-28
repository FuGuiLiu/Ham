package com.sky.ham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    private Integer COMMENT_ID;

    private Integer COM_COMMENT_ID;

    private Integer USER_ID;

    private Integer z_COUNT;

    private String COMMENT_CONTENT;

}