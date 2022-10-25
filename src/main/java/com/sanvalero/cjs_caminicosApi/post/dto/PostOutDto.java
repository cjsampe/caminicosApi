package com.sanvalero.cjs_caminicosApi.post.dto;

import com.sanvalero.cjs_caminicosApi.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostOutDto extends BaseOutDto {
    String user;
    String post;
}
