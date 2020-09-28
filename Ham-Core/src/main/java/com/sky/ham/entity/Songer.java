package com.sky.ham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Songer {
    private Integer SRID;
    @DecimalMin(value = "1", message = "歌手的唱歌风格类型不能为空")
    private Integer TID;
    @NotBlank(message = "歌手的名称不能为空")
    private String SRNAME;
    @NotBlank(message = "歌手所在的地区不能为空")
    private String AREA;
    @NotBlank(message = "歌手的的图片不能为空")
    private String PIC;
    @DecimalMax(value = "1", message = "无效的歌手火热度")
    @DecimalMin(value = "0", message = "无效的歌手火热度")
    private Integer IS_HOT;
    @NotBlank(message = "歌手的自我介绍不能为空")
    private String INTRO;

    private String TNAME;
}