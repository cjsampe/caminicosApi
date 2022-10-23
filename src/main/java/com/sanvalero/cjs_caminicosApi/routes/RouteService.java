package com.sanvalero.cjs_caminicosApi.routes;

import com.sanvalero.cjs_caminicosApi.routes.dto.RouteInDto;
import com.sanvalero.cjs_caminicosApi.routes.dto.RouteOutDto;

import java.util.List;
import java.util.Map;

public interface RouteService {
    List<RouteOutDto> get();

    RouteOutDto get(long id);

   /** List<Route> findByProvince(String province);**/

    RouteOutDto post(RouteInDto routeInDto);

    RouteOutDto put(long id, RouteInDto routeInDto);

    RouteOutDto patch(long id, Map<String, Object> patchParameters);

    void delete(long id);
}
