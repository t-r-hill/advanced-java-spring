package platform.codingnomads.co.springdata.springtest.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.springtest.lab.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
