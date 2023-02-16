package platform.codingnomads.co.springweb.resttemplate.POST.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserResponseObject {
    User data;
    Error error;
    String status;
}
