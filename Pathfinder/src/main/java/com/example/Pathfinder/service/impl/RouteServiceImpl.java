package com.example.Pathfinder.service.impl;

import com.example.Pathfinder.models.entity.enums.dto.MostCommentedRouteViewDto;
import com.example.Pathfinder.repository.RouteRepository;
import com.example.Pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public MostCommentedRouteViewDto getMostCommented() {
        return MostCommentedRouteViewDto.fromRoute(this.routeRepository
                .findMostCommented()
                .orElseThrow(NoSuchElementException::new)
                .get(0));
    }
}
