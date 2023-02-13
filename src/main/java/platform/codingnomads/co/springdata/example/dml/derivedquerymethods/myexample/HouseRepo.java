package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepo extends JpaRepository<House, Long> {

    List<House> getByNumFloorsGreaterThan(int numFloors);

    List<House> getByAddress_HouseNumberGreaterThan(int houseNumber);

    int countByAddress_PostCode(String postCode);

    List<House> getByNumFloorsLessThanEqualAndNumBedroomsGreaterThan(int numFloors, int numBedrooms);

    List<House> getByAddress_PostCodeStartingWith(String postCodePrefix);




}
