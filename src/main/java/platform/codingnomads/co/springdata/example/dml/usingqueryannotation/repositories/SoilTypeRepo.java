package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.List;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query("SELECT st FROM SoilType st WHERE dry = ?1")
    List<SoilType> getSoilTypeByDry(boolean dry);

    @Query("SELECT st FROM SoilType st WHERE name LIKE ?1%")
    List<SoilType> getSoilTypeByNamePrefix(String namePrefix);

    @Query("SELECT COUNT(st.id) FROM SoilType st WHERE ph > ?1")
    int getCountOfSoilTypeByPhGreaterThan(double ph);

    @Query("SELECT st FROM SoilType st")
    Page<SoilType> getAllSoilType(Pageable pageable);
}
