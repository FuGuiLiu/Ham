package com.sky.ham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Album {
    private Integer AID;
    @NotBlank(message = "专辑名称不能为空")
    private String ANAME;
    @NotBlank(message = "封面内容不能为空")
    private String PIC;
    @NotBlank(message = "唱片公司不能为空")
    private String COMPANY;
    @NotBlank(message = "发行时间不能为空")
    private String PDATE;
    @NotBlank(message = "语种不能为空")
    private String LANG;

}