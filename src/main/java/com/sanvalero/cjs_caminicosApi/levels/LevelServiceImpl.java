package com.sanvalero.cjs_caminicosApi.levels;


import com.sanvalero.cjs_caminicosApi.levels.dto.LevelInDto;
import com.sanvalero.cjs_caminicosApi.levels.dto.LevelOutDto;
import com.sanvalero.cjs_caminicosApi.levels.exception.LevelNotFoundException;
import com.sanvalero.cjs_caminicosApi.levels.model.Level;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LevelOutDto> get(){
        List<Level> levels = levelRepository.findAll();
        return getLevelOutDtos(levels);
    }

    @Override
    public LevelOutDto get(long id){
        return getLevelOutDto(getPostOrFail(id));
    }


    @Override
    public LevelOutDto post(LevelInDto levelInDto) {
        Level newLevel = new Level();
        modelMapper.map(levelInDto, newLevel);
        levelRepository.save(newLevel);
        return getLevelOutDto(newLevel);
    }

    @Override
    public LevelOutDto put(long id, LevelInDto levelInDto){
        Level level = getPostOrFail(id);
        modelMapper.map(levelInDto, level);
        levelRepository.save(level);
        return getLevelOutDto(level);
    }

    @Override
    public LevelOutDto patch(long id, Map<String, Object> patchParameters) {
        Level level = getPostOrFail(id);
        patchParameters.forEach((key, value) ->{
            switch (key){
                case "characteristics;":
                    level.setCharacteristics(String.valueOf(value));
                    break;
            }
        });
        levelRepository.save(level);
        return getLevelOutDto(level);
    }

    @Override
    public void delete(long id) {
        getPostOrFail(id);
        levelRepository.deleteById(id);
    }

    private Level getPostOrFail(long id) {
        return levelRepository.findById(id).orElseThrow(() -> new LevelNotFoundException(id));
    }

    private LevelOutDto getLevelOutDto(Level level){
        LevelOutDto out = new LevelOutDto();
        modelMapper.map(level, out);
        return out;
    }

    private List<LevelOutDto> getLevelOutDtos(List<Level> levels) {
        List<LevelOutDto> out = new ArrayList<>();
        levels.forEach(level -> out.add(getLevelOutDto(level)));
        return out;
    }
}
