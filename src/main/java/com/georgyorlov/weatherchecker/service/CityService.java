package com.georgyorlov.weatherchecker.service;


import com.georgyorlov.weatherchecker.model.City;
import com.georgyorlov.weatherchecker.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
