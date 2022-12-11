package com.sanvalero.cjs_caminicosApi.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInDto {
    String name;
    String user;
    String post;
    long route;
}
