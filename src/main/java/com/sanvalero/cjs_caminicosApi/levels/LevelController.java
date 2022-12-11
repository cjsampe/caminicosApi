package com.sanvalero.cjs_caminicosApi.levels;

import com.sanvalero.cjs_caminicosApi.levels.dto.LevelInDto;
import com.sanvalero.cjs_caminicosApi.levels.dto.LevelOutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins ="*")
public class LevelController {
    private static final String PATH = "/levels";

    private final Logger log = LoggerFactory.getLogger(LevelController.class);

    @Autowired
    private LevelService levelService;

    @GetMapping(PATH)
    public ResponseEntity<List<LevelOutDto>> get(){
        return ResponseEntity.ok(levelService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<LevelOutDto> post(@RequestBody LevelInDto levelInDto) throws URISyntaxException {
        LevelOutDto levelOutDto = levelService.post(levelInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + levelOutDto.getId()))
                .body(levelOutDto);
    }


    @GetMapping(PATH + "/{id}")
    public ResponseEntity<LevelOutDto> get(@PathVariable long id){
        LevelOutDto levelOutDto = levelService.get(id);
        return ResponseEntity.ok(levelOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        levelService.delete(id);
        log.info("Level removerd / Nivel eliminado");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<LevelOutDto> put(@PathVariable long id,
                                           @RequestBody LevelInDto levelInDto) {
        return ResponseEntity.ok(levelService.put(id, levelInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<LevelOutDto> path(@PathVariable long id,
                                            @RequestBody Map<String, Object> patchParameters) {
        LevelOutDto levelOutDto = levelService.patch(id, patchParameters);
        log.info("Level modified/ Nivel modificado");
        return ResponseEntity.ok(levelOutDto);
    }
}
