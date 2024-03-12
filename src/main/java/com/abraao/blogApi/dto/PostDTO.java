package com.abraao.blogApi.dto;

public record PostDTO(
    String title,
    String content,
    Long userId
) {
}
