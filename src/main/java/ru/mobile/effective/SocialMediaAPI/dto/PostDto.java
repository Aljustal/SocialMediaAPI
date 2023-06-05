package ru.mobile.effective.SocialMediaAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String text;
    private String title;
    private UserDto user;
}