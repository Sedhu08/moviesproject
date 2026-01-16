package com.example.moviedb.service;

import com.example.moviedb.domain.Genre;
import com.example.moviedb.repository.GenreRepository;
import com.example.moviedb.web.dto.GenreDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GenreDTO> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public GenreDTO getGenreById(Long id) {
        return genreRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Genre not found with id: " + id));
    }

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = toEntity(genreDTO);
        genre = genreRepository.save(genre);
        return toDTO(genre);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    private GenreDTO toDTO(Genre genre) {
        return new GenreDTO(genre.getId(), genre.getName());
    }

    private Genre toEntity(GenreDTO genreDTO) {
        return new Genre(genreDTO.getId(), genreDTO.getName());
    }
}
