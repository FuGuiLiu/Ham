package com.sky.ham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

public class MType {
    private Integer TID;

    @NotBlank(message = "媒体的流派不能为空")
    private String TNAME;

    @NotBlank(message = "媒体描述不能空")
    private String TDESC;
}