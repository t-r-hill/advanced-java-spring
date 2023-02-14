package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Checkpoint;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.CheckpointRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;

    private final RouteRepository routeRepository;

    private final CheckpointRepository checkpointRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().isEmpty()){
            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build(),
                            Area.builder().code("F").build(),
                            Area.builder().code("E").build(),
                            Area.builder().code("L").build(),
                            Area.builder().code("I").build(),
                            Area.builder().code("X").build()
                    )
            );
        }

        if (routeRepository.findAll().isEmpty()){
            char[] felix = "FELIX".toCharArray();

            for (int i = 0; i < (felix.length - 1); i++){
                routeRepository.save(
                        Route.builder()
                                .origin(areaRepository.getByCode(String.valueOf(felix[i])))
                                .destination(areaRepository.getByCode(String.valueOf(felix[i+1])))
                                .build()
                );
            }
        }

        System.out.println(routeRepository.getByOrigin(areaRepository.getByCode("F")));
        System.out.println(routeRepository.getByDestination(areaRepository.getByCode("L")));
        System.out.println(routeRepository.getByCode("L-I"));

        Route newRoute = Route.builder()
                .origin(areaRepository.getByCode("F"))
                .destination(areaRepository.getByCode("X"))
                .build();

        newRoute = routeRepository.save(newRoute);

        char[] felix = "FELIX".toCharArray();

        for (int i = 1; i < (felix.length - 1); i++){
            Checkpoint cp = checkpointRepository.save(
                    Checkpoint.builder()
                            .location(areaRepository.getByCode(String.valueOf(felix[i])))
                            .number(i)
                            .route(newRoute)
                            .build()
            );
        }

        routeRepository.getByOrigin(areaRepository.getByCode("F")).forEach(System.out::println);
    }
}
