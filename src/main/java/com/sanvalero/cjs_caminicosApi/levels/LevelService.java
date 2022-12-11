package com.sanvalero.cjs_caminicosApi.levels;

import com.sanvalero.cjs_caminicosApi.levels.dto.LevelInDto;
import com.sanvalero.cjs_caminicosApi.levels.dto.LevelOutDto;

import java.util.List;
import java.util.Map;

public interface LevelService {
    List<LevelOutDto> get();

    LevelOutDto get(long id);

    LevelOutDto post(LevelInDto levelInDto);

    LevelOutDto put(long id, LevelInDto levelInDto);

    LevelOutDto patch(long id, Map<String, Object> patchParameters);

    void delete(long id);
}
