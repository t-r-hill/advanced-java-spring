package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Checkpoint;
import platform.codingnomads.co.springdata.lab.models.Route;

import java.util.List;

public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {

    List<Checkpoint> getByRoute(Route route);


}
