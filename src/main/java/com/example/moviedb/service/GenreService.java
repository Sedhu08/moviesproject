package com.example.moviedb.service;

import com.example.moviedb.web.dto.GenreDTO;
import java.util.List;

public interface GenreService {
    List<GenreDTO> getAllGenres();

    GenreDTO getGenreById(Long id);

    GenreDTO createGenre(GenreDTO genreDTO);

    void deleteGenre(Long id);
}
