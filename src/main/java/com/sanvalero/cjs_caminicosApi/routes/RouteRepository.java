package com.sanvalero.cjs_caminicosApi.routes;

import com.sanvalero.cjs_caminicosApi.routes.model.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
     List<Route> findAll();
     List<Route> findByProvince(String province);


}
