package com.example.test2.controller;

import com.example.test2.model.Anime;
import com.example.test2.service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animes")
@AllArgsConstructor
public class AnimeListController {

    private final AnimeService animeService;

    @GetMapping
    public List<Anime> animeList() {
        return animeService.getAnimeList();
    }
}
