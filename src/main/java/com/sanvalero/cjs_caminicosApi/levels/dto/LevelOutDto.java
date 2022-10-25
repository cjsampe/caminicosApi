package com.sanvalero.cjs_caminicosApi.levels.dto;

import com.sanvalero.cjs_caminicosApi.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelOutDto extends BaseOutDto {
    String name;
    String characteristics;
}
