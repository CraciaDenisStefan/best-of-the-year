package org.java.spring.controller;

import org.java.spring.Movie;
import org.java.spring.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String getTitle(Model model) {
        final String name = "denis";
        model.addAttribute("name", name);
        return "Title";
    }

    private List<Movie> getBestMovies() {
        return Arrays.asList(
                new Movie(1, "Film 1"),
                new Movie(2, "Film 2"),
                new Movie(3, "Film 3")
        );
    }

    private List<Song> getBestSongs() {
        return Arrays.asList(
                new Song(101, "Canzone 1"),
                new Song(102, "Canzone 2"),
                new Song(103, "Canzone 3")
        );
    }

    @GetMapping("/movie")
    public String getMovies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movie";
    }

    @GetMapping("/song")
    public String getSongs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "Song";
    }

    @GetMapping("/movie/{id}")
    public String getMovieById(Model model, @PathVariable int id) {
        List<Movie> movies = getBestMovies();

        String title = "Elemento non trovato";  

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                title = movie.getTitle();
                break;
            }
        }

        model.addAttribute("title", title);
        model.addAttribute("id", id);
        return "MovieShow";
    }
    
    @GetMapping("/song/{id}")
    public String getSongById(Model model, @PathVariable int id) {
        List<Song> songs = getBestSongs();

        String title = "Elemento non trovato";  

        for (Song song : songs) {
            if (song.getId() == id) {
                title = song.getTitle();
                break;
            }
        }

        model.addAttribute("title", title);
        model.addAttribute("id", id);
        return "SongShow";
    }


}
