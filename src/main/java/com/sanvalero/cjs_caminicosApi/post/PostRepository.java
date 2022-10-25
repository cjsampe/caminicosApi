package com.sanvalero.cjs_caminicosApi.post;

import com.sanvalero.cjs_caminicosApi.post.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
     List<Post> findAll();


}
