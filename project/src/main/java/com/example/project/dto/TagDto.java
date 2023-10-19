package com.example.project.dto;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("TagDTO")
@Getter
@Setter
public class TagDto {
    private int code;
    private String cd_name;
    private char use_yn;

}
