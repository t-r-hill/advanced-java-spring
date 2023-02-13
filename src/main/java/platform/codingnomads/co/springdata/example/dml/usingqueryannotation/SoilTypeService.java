package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SoilTypeService {

    @Autowired
    private SoilTypeRepo soilTypeRepo;

    @Transactional
    void saveStuff(){
        SoilType soilType1 = SoilType.builder()
                .name("Dry acidid")
                .ph(3)
                .dry(true).build();

        SoilType soilType2 = SoilType.builder()
                .name("Damp alkaline")
                .ph(8)
                .dry(false).build();

        SoilType soilType3 = SoilType.builder()
                .name("Dry neutral")
                .ph(7)
                .dry(true).build();

        soilTypeRepo.saveAll(List.of(soilType1, soilType2, soilType3));
    }

    @Transactional
    void getStuff(){

        Pageable pageRequest = PageRequest.of(0,2);

        Page<SoilType> soilTypePage;

        soilTypePage = soilTypeRepo.getAllSoilType(pageRequest);

        System.out.println("---Page 1 of soil types---");
        soilTypePage.getContent().forEach(System.out::println);

        pageRequest = pageRequest.next();

        soilTypePage = soilTypeRepo.getAllSoilType(pageRequest);

        System.out.println("---Page 2 of soil types---");
        soilTypePage.getContent().forEach(System.out::println);

        System.out.println("---All dry soil types---");
        soilTypeRepo.getSoilTypeByDry(true).forEach(System.out::println);

        System.out.println("---Also dry soil types---");
        soilTypeRepo.getSoilTypeByNamePrefix("Dry").forEach(System.out::println);

        System.out.println("---How many non acidic ph---");
        System.out.println(soilTypeRepo.getCountOfSoilTypeByPhGreaterThan(6));

    }
}
