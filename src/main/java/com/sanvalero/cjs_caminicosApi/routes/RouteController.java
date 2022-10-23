package com.sanvalero.cjs_caminicosApi.routes;

import com.sanvalero.cjs_caminicosApi.routes.dto.RouteInDto;
import com.sanvalero.cjs_caminicosApi.routes.dto.RouteOutDto;
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
public class RouteController {
    private static final String PATH = "/routes";

    private final Logger log = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    private RouteService routeService;

    @GetMapping(PATH)
    public ResponseEntity<List<RouteOutDto>> get(){
        return ResponseEntity.ok(routeService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<RouteOutDto> post(@RequestBody RouteInDto routeInDto) throws URISyntaxException {
        RouteOutDto routeOutDto = routeService.post(routeInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + routeOutDto.getId()))
                .body(routeOutDto);
    }


    @GetMapping(PATH + "/{id}")
    public ResponseEntity<RouteOutDto> get(@PathVariable long id){
        RouteOutDto routeOutDto = routeService.get(id);
        return ResponseEntity.ok(routeOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        routeService.delete(id);
        log.info("Route removerd / Ruta eliminada");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<RouteOutDto> put(@PathVariable long id,
                                           @RequestBody RouteInDto routeInDto) {
        return ResponseEntity.ok(routeService.put(id, routeInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<RouteOutDto> path(@PathVariable long id,
                                            @RequestBody Map<String, Object> patchParameters) {
        RouteOutDto routeOutDto = routeService.patch(id, patchParameters);
        log.info("Route modified/ Ruta modificada");
        return ResponseEntity.ok(routeOutDto);
    }
}
