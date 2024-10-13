package com.example.test1.service;

import com.example.test1.model.Anime;
import com.example.test1.service.client.AnimeClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenreService {

    private final AnimeClient animeClient;

    public List<Anime> getAnimeByGenre(String genre) {
        List<Anime> anime = animeClient.animeList();

        return anime
                .stream()
                .filter(m -> m.genre().equalsIgnoreCase(genre))
                .toList();
    }
}
