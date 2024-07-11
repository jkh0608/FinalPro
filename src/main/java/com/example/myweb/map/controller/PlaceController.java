package com.example.myweb.map.controller;

import com.example.myweb.map.model.Place;
import com.example.myweb.map.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlaceController {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/")
    public String showMap(Model model) {
        List<Place> places = placeRepository.findAll();
        model.addAttribute("places", places);
        return "map"; // map.html 페이지로 이동
    }
}
