package com.samsungdisplay.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samsungdisplay.movie.entity.Movie;
import com.samsungdisplay.movie.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movies/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/form";
    }

    @PostMapping
    public String save(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movies";
    }

		@GetMapping("/{id}")
		public String detail(@PathVariable("id") Long id, Model model) {
		    Movie movie = movieRepository.findById(id).orElseThrow();
		    model.addAttribute("movie", movie);
		    return "movies/detail";
		}
}
