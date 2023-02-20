package platform.codingnomads.co.springdata.springtest.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springdata.springtest.lab.entity.Movie;
import platform.codingnomads.co.springdata.springtest.lab.repository.MovieRepository;

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
}
