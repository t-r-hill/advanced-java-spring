package platform.codingnomads.co.springweb.resttemplate.PUT.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseObject {

    private User[] data;
    private Error error;
    private String status;
}
