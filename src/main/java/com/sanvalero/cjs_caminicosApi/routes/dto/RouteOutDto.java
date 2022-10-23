package com.sanvalero.cjs_caminicosApi.routes.dto;

import com.sanvalero.cjs_caminicosApi.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteOutDto extends BaseOutDto {
    String village;
    String province;
    String title;
    String description;
    float km;
    String signaling;
    String season;
    int unevenness;
    Boolean circular;
    String time;
}