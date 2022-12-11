package com.sanvalero.cjs_caminicosApi.post;


import com.sanvalero.cjs_caminicosApi.post.dto.PostInDto;
import com.sanvalero.cjs_caminicosApi.post.dto.PostOutDto;
import com.sanvalero.cjs_caminicosApi.post.exception.PostNotFoundException;
import com.sanvalero.cjs_caminicosApi.post.model.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostOutDto> get(){
        List<Post> posts = postRepository.findAll();
        return getPostOutDtos(posts);
    }

    @Override
    public PostOutDto get(long id){
        return getPostOutDto(getPostOrFail(id));
    }



    @Override
    public PostOutDto post(PostInDto postInDto) {
        Post newPost = new Post();
        modelMapper.map(postInDto, newPost);
        postRepository.save(newPost);
        return getPostOutDto(newPost);
    }

    @Override
    public PostOutDto put(long id, PostInDto postInDto){
        Post post = getPostOrFail(id);
        modelMapper.map(postInDto, post);
        postRepository.save(post);
        return getPostOutDto(post);
    }

    @Override
    public PostOutDto patch(long id, Map<String, Object> patchParameters) {
        Post post = getPostOrFail(id);
        patchParameters.forEach((key, value) ->{
            switch (key){
                case "user":
                    post.setUser(String.valueOf(value));
                    break;
                case "post":
                    post.setPost(String.valueOf(value));
                    break;
            }
        });
        postRepository.save(post);
        return getPostOutDto(post);
    }

    @Override
    public void delete(long id) {
        getPostOrFail(id);
        postRepository.deleteById(id);
    }

    private Post getPostOrFail(long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    private PostOutDto getPostOutDto(Post post){
        PostOutDto out = new PostOutDto();
        modelMapper.map(post, out);
        return out;
    }

    private List<PostOutDto> getPostOutDtos(List<Post> posts) {
        List<PostOutDto> out = new ArrayList<>();
        posts.forEach(post -> out.add(getPostOutDto(post)));
        return out;
    }
}
