package com.sanvalero.cjs_caminicosApi.post;

import com.sanvalero.cjs_caminicosApi.post.dto.PostInDto;
import com.sanvalero.cjs_caminicosApi.post.dto.PostOutDto;

import java.util.List;
import java.util.Map;

public interface PostService {
    List<PostOutDto> get();

    PostOutDto get(long id);

    PostOutDto post(PostInDto postInDto);

    PostOutDto put(long id, PostInDto postInDto);

    PostOutDto patch(long id, Map<String, Object> patchParameters);

    void delete(long id);
}
