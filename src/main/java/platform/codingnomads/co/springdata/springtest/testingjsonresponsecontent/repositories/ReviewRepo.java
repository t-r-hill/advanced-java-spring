package platform.codingnomads.co.springdata.springtest.testingjsonresponsecontent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.springtest.testingjsonresponsecontent.models.Review;

import java.util.ArrayList;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    ArrayList<Review> findByUsername(String username);

}
