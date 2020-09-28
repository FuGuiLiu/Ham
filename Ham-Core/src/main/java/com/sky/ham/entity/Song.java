package com.sky.ham.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.List;

/**
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Song {
    private Integer SID;
    @DecimalMin(value = "1", message = "流派ID不能为空")
    private Integer TID;
    @DecimalMin(value = "1", message = "歌手ID不能为空")
    private Integer SRID;
    @DecimalMin(value = "1", message = "专辑ID不能为空")
    private Integer AID;
    @NotBlank(message = "歌名不能为空")
    private String SNAME;

    private String PIC;
    @NotBlank(message = "请上传一首音乐")
    private String MP3;
    @DecimalMax(value = "1", message = "无效的歌手火热度")
    @DecimalMin(value = "0", message = "无效的歌手火热度")
    private Integer IS_HOT;
    @DecimalMax(value = "1", message = "无效的知名度")
    @DecimalMin(value = "0", message = "无效的知名度")
    private Integer IS_NEW;

    private Integer PTIMES;

    private Integer AUDIT_STATUS;

    private Integer SHOW_STATUS;
    @NotBlank(message = "歌词内容不能为空")
    private String LRC;

    private String SRNAME;

    private String ANAME;

    private String TNAME;
}