package com.sanvalero.cjs_caminicosApi.post;

import com.sanvalero.cjs_caminicosApi.post.dto.PostInDto;
import com.sanvalero.cjs_caminicosApi.post.dto.PostOutDto;
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
public class PostController {
    private static final String PATH = "/posts";

    private final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @GetMapping(PATH)
    public ResponseEntity<List<PostOutDto>> get(){
        return ResponseEntity.ok(postService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<PostOutDto> post(@RequestBody PostInDto postInDto) throws URISyntaxException {
        PostOutDto postOutDto = postService.post(postInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + postOutDto.getId()))
                .body(postOutDto);
    }


    @GetMapping(PATH + "/{id}")
    public ResponseEntity<PostOutDto> get(@PathVariable long id){
        PostOutDto postOutDto = postService.get(id);
        return ResponseEntity.ok(postOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        postService.delete(id);
        log.info("Post removerd / Post eliminado");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<PostOutDto> put(@PathVariable long id,
                                          @RequestBody PostInDto postInDto) {
        return ResponseEntity.ok(postService.put(id, postInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<PostOutDto> path(@PathVariable long id,
                                           @RequestBody Map<String, Object> patchParameters) {
        PostOutDto postOutDto = postService.patch(id, patchParameters);
        log.info("Post modified/ Post modificado");
        return ResponseEntity.ok(postOutDto);
    }
}
