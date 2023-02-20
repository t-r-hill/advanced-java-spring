package platform.codingnomads.co.springdata.springtest.mockingmethods.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.springtest.mockingmethods.models.Review;

import java.util.ArrayList;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    ArrayList<Review> findByUsername(String username);

}