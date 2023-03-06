package platform.codingnomads.co.springsecurity.authorization.addingauthorization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.MagicBean;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.repositories.MagicBeanRepo;

import java.util.List;

@Service
public class MagicBeanService {

    @Autowired
    MagicBeanRepo magicBeanRepo;

    @PostAuthorize("returnObject.user == authentication.principal.username")
    public MagicBean getBeanByColour(String colour) throws IllegalArgumentException{
        List<MagicBean> beans = magicBeanRepo.getByColour(colour);
        if (!beans.isEmpty()){
            return beans.get(0);
        } else{
            throw new IllegalArgumentException("Couldn't find any beans with colour " + colour);
        }
    }

    @PostFilter("filterObject.colour != 'PURPLE'")
    public List<MagicBean> getAllBeans(){
        List<MagicBean> allBeans = magicBeanRepo.findAll();
        if (!allBeans.isEmpty()){
            return allBeans;
        } else{
            throw new IllegalArgumentException("Couldn't find any beans");
        }
    }
}
