package platform.codingnomads.co.springdata.springtest.mockingmethods.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.springtest.mockingmethods.models.Recipe;

import java.util.ArrayList;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    ArrayList<Recipe> findByNameContaining(String name);
}
