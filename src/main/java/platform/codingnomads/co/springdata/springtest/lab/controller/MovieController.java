package platform.codingnomads.co.springdata.springtest.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.codingnomads.co.springdata.springtest.lab.service.MovieService;
import platform.codingnomads.co.springdata.springtest.lab.entity.Movie;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
