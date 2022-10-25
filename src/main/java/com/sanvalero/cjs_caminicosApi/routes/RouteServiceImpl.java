package com.sanvalero.cjs_caminicosApi.routes;


import com.sanvalero.cjs_caminicosApi.routes.dto.RouteInDto;
import com.sanvalero.cjs_caminicosApi.routes.dto.RouteOutDto;
import com.sanvalero.cjs_caminicosApi.routes.exception.RouteNotFoundException;
import com.sanvalero.cjs_caminicosApi.routes.model.Route;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RouteOutDto> get(){
        List<Route> routes = routeRepository.findAll();
        return getRouteOutDtos(routes);
    }

    @Override
    public RouteOutDto get(long id){
        return getRouteOutDto(getRouteOrFail(id));
    }
/**
    @Override
    public List<Route> findByProvince(String province) {
        List<Route> routes = routeRepository.findByProvince(province);
        return routes;

    }**/

    @Override
    public RouteOutDto post(RouteInDto routeInDto) {
        Route newRoute = new Route();
        modelMapper.map(routeInDto, newRoute);
        routeRepository.save(newRoute);
        return getRouteOutDto(newRoute);
    }

    @Override
    public RouteOutDto put(long id, RouteInDto routeInDto){
        Route route = getRouteOrFail(id);
        modelMapper.map(routeInDto, route);
        routeRepository.save(route);
        return getRouteOutDto(route);
    }

    @Override
    public RouteOutDto patch(long id, Map<String, Object> patchParameters) {
        Route route = getRouteOrFail(id);
        patchParameters.forEach((key, value) ->{
            switch (key){
                case "village":
                    route.setVillage(String.valueOf(value));
                    break;
                case "province":
                    route.setProvince(String.valueOf(value));
                    break;
                case "title":
                    route.setTitle(String.valueOf(value));
                    break;
                case "description":
                    route.setDescription(String.valueOf(value));
                    break;
                case "km":
                    route.setKm(Float.parseFloat(String.valueOf(value)));
                    break;
                case "signaling":
                    route.setSignaling(String.valueOf(value));
                    break;
                case "season":
                    route.setSeason(String.valueOf(value));
                    break;
                case "unevenness":
                    route.setUnevenness(Integer.parseInt(String.valueOf(value)));
                    break;
                case "circular":
                    route.setCircular(Boolean.parseBoolean(String.valueOf(value)));
                    break;
                case "time":
                    route.setTime(String.valueOf(value));
                    break;
                case "map":
                    route.setMap(String.valueOf(value));
                    break;
                case "photo1":
                    route.setPhoto1(String.valueOf(value));
                    break;
                case "photo2":
                    route.setPhoto2(String.valueOf(value));
                    break;
                case "photo3":
                    route.setPhoto3(String.valueOf(value));
                    break;
            }
        });
        routeRepository.save(route);
        return getRouteOutDto(route);
    }

    @Override
    public void delete(long id) {
        getRouteOrFail(id);
        routeRepository.deleteById(id);
    }

    private Route getRouteOrFail(long id) {
        return routeRepository.findById(id).orElseThrow(() -> new RouteNotFoundException(id));
    }

    private RouteOutDto getRouteOutDto(Route route){
        RouteOutDto out = new RouteOutDto();
        modelMapper.map(route, out);
        return out;
    }

    private List<RouteOutDto> getRouteOutDtos(List<Route> routes) {
        List<RouteOutDto> out = new ArrayList<>();
        routes.forEach(route -> out.add(getRouteOutDto(route)));
        return out;
    }
}
