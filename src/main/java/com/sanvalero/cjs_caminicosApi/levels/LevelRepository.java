package com.sanvalero.cjs_caminicosApi.levels;

import com.sanvalero.cjs_caminicosApi.levels.model.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LevelRepository extends CrudRepository<Level, Long> {
     List<Level> findAll();


}
