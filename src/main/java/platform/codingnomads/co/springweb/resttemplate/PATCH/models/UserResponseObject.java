package platform.codingnomads.co.springweb.resttemplate.PATCH.models;

import lombok.Builder;
import lombok.Data;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.Error;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.User;

@Data
@Builder
public class UserResponseObject {

    private User data;
    private Error error;
    private String status;
}
