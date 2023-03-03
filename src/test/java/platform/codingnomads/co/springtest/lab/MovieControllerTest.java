package platform.codingnomads.co.springtest.lab;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = SpringTestLab.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;

    @MockBean
    private MovieService movieService;

    @Test
    @Order(1)
    public void testGetAllMoviesSuccess() throws Exception {

        mockMvc.perform(get("/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$(0).name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$(1).rating").value(8.0));

    }

    @Test
    @Order(2)
    public void testGetAllMoviesFailure() throws Exception {

        movieRepository.deleteAll();

        mockMvc.perform(get("/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.empty()));

    }

    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {

        List<Movie> movies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()
        );

        when(movieService.getAllMovies()).thenReturn(movies);

        mockMvc.perform(get("/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(movies.size())))
                .andExpect(jsonPath("$(0).name").value(movies.get(0).getName()));
    }

    @Test
    public void testGetAllMoviesSuccess2() throws Exception {
        List<Movie> movies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()
        );

        when(movieService.getAllMovies()).thenReturn(movies);

        byte[] byteArrayResponse = mockMvc.perform(get("/all/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse().getContentAsByteArray();

        Movie[] moviesResponse = TestUtil.convertJsonBytesToObject(byteArrayResponse, Movie[].class);

        assertThat(moviesResponse).hasSize(movies.size());
        assertThat(moviesResponse[0].getName()).isEqualTo(movies.get(0).getName());
    }

    @Test
    public void testGetMoviesWithMinimumRatingSuccess() throws Exception {
        List<Movie> movies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()
        );

        when(movieService.getMoviesWithMinimumRating(anyDouble())).thenReturn(movies);

        mockMvc.perform(get("/rating/minimum/4.5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$(0).name").value(movies.get(0).getName()));
    }

    @Test
    public void testGetMoviesWithMinimumRatingFailure() throws Exception {
        Double minRating = 4.2;

        when(movieService.getMoviesWithMinimumRating(anyDouble())).thenThrow(new IllegalArgumentException("No movies with a rating above " + minRating));

        mockMvc.perform(get("/rating/minimum/" + minRating))
                .andExpect(status().isNotFound())
                .andExpect(content().string("No movies with a rating above " + minRating));
    }
}
