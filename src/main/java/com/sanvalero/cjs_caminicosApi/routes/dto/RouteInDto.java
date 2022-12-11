package com.sanvalero.cjs_caminicosApi.routes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteInDto {
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
    long level;
    int max;
    int min;

}
