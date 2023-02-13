package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here
    @PrePersist
    void prePersist(){
        System.out.println("Pre-persist");
    }

    @PostPersist
    void postPersist(){
        System.out.println("Post-persist");
    }

    @PreUpdate
    void preUpdate(){
        System.out.println("Pre-update");
    }

    @PostUpdate
    void postUpdate(){
        System.out.println("Post-update");
    }

    @PostLoad
    void postLoad(){
        System.out.println("Post-load");
    }

    @PreRemove
    void preRemove(){
        System.out.println("Pre-remove");
    }

    @PostRemove
    void postRemove(){
        System.out.println("Post-remove");
    }

}
