package platform.codingnomads.co.springsecurity.authorization.addingauthorization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.MagicBean;

import java.util.List;

@Repository
public interface MagicBeanRepo extends JpaRepository<MagicBean, Long> {

    List<MagicBean> getByColour(String colour);

    List<MagicBean> getByUser(String user);

    List<MagicBean> getByRole(String role);


}
