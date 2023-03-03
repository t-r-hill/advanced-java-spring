package platform.codingnomads.co.springtest.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesWithMinimumRating(Double minRating) throws IllegalArgumentException {
        List<Movie> movies = movieRepository.getByRatingGreaterThanEqual(minRating);
        if (movies == null || movies.isEmpty()){
            throw new IllegalArgumentException("No movies with a rating above " + minRating);
        }
        return movies;
    }
}
