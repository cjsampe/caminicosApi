package com.sanvalero.cjs_caminicosApi.routes.dto;

import com.sanvalero.cjs_caminicosApi.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteOutDto extends BaseOutDto {
    String name;
    String village;
    String province;
    String title;
    String description;
    float km;
    String season;
    int unevenness;
    String type;
    String time;
    String photo1;
    String photo2;
    String levelys;
    int max;
    int min;
    long level;
}
