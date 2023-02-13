package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    HouseRepo houseRepo;

    @Autowired
    AddressRepo addressRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Address wimbledon = Address.builder().houseNumber(1).postCode("SW19").build();
        Address me = Address.builder().houseNumber(2).postCode("RG45").build();
        Address southfields = Address.builder().houseNumber(2).postCode("SW19").build();
        Address earlsfield = Address.builder().houseNumber(3).postCode("SW18").build();

        addressRepo.saveAll(List.of(wimbledon, me, southfields, earlsfield));

        House wimbledonFlat = House.builder()
                .address(wimbledon)
                .type("flat")
                .numBedrooms(3)
                .numFloors(2)
                .build();

        House wimbledonHouse = House.builder()
                .address(wimbledon)
                .type("detached house")
                .numBedrooms(6)
                .numFloors(3)
                .build();

        House myHouse = House.builder()
                .address(me)
                .type("terraced house")
                .numBedrooms(4)
                .numFloors(2)
                .build();

        House earlsfieldFlat = House.builder()
                .address(earlsfield)
                .type("flat")
                .numFloors(1)
                .numBedrooms(2)
                .build();

        List<House> house = houseRepo.saveAll(List.of(wimbledonFlat, wimbledonHouse, myHouse, earlsfieldFlat));

        System.out.println("---All houses with more than 1 floor---");
        houseRepo.getByNumFloorsGreaterThan(1)
                .forEach(System.out::println);

        System.out.println("---How many houses in Wimbledon---");
        System.out.println(houseRepo.countByAddress_PostCode("SW19"));

        System.out.println("---These are not the first house in the road---");
        houseRepo.getByAddress_HouseNumberGreaterThan(1).forEach(System.out::println);

        System.out.println("---These are south-west london houses");
        houseRepo.getByAddress_PostCodeStartingWith("SW").forEach(System.out::println);

        System.out.println("---More than 2 bedrooms and less than or equal to 2 floors");
        houseRepo.getByNumFloorsLessThanEqualAndNumBedroomsGreaterThan(2,2).forEach(System.out::println);
    }
}
