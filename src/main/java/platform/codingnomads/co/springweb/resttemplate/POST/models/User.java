package platform.codingnomads.co.springweb.resttemplate.POST.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

    private long id;

    private String email;
    private String first_name;
    private String last_name;
    private String created_at;
    private String updated_at;

}
