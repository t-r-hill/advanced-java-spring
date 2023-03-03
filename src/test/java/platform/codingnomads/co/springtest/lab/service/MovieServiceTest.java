package platform.codingnomads.co.springtest.lab.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringTestLab.class)
class MovieServiceTest {

    @MockBean
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @Test
    public void testGetAllMoviesSuccess() {
        List<Movie> movies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()
        );

        when(movieRepository.findAll()).thenReturn(movies);

        List<Movie> testMovies = movieService.getAllMovies();

        assertThat(testMovies.size()).isEqualTo(movies.size());
        assertThat(testMovies.get(0).getName()).isEqualTo(movies.get(0).getName());
    }

    @Test
    public void testGetAllMoviesFailure(){
        List<Movie> movies = new ArrayList<>();

        when(movieRepository.findAll()).thenReturn(movies);

        List<Movie> testMovies = movieService.getAllMovies();

        assertThat(testMovies.size()).isEqualTo(movies.size());
    }

    @Test
    void testGetMoviesWithMinimumRatingSuccess() {
        List<Movie> movies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()
        );

        when(movieRepository.getByRatingGreaterThanEqual(anyDouble())).thenReturn(movies);

        List<Movie> testMovies = movieService.getMoviesWithMinimumRating(4.2);

        assertThat(testMovies.size()).isEqualTo(movies.size());
        assertThat(testMovies.get(0).getName()).isEqualTo(movies.get(0).getName());
    }

    @Test
    void testGetMoviesWithMinimumRatingFailure(){
        Double rating = 4.2;
        List<Movie> movies = new ArrayList<>();

        when(movieRepository.getByRatingGreaterThanEqual(anyDouble())).thenReturn(movies);

        assertThrows(IllegalArgumentException.class,
                () -> movieService.getMoviesWithMinimumRating(rating),
                "No movies with a rating above " + rating);
    }
}