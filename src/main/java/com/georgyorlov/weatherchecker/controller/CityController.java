package com.georgyorlov.weatherchecker.controller;

import com.georgyorlov.weatherchecker.service.WeatherApiChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController("/city")
public class CityController {

    private final WeatherApiChecker weatherApiChecker;

    @GetMapping(path ="/get/{cityName}")
    public String get(@PathVariable String cityName) {
        return weatherApiChecker.update(cityName);
    }

    @PostMapping(path="/create")
    public void create(@RequestBody Object obj) {
        //without id
    }

    @PutMapping(path="/update/{id}")
    public void update(@RequestBody Object obj,
                       @PathVariable UUID uuid) {
        //with id
    }

    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable UUID uuid) {

    }

}
