package platform.codingnomads.co.springweb.resttemplate.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.User;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.UserResponseObject;

@SpringBootApplication
public class PutMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PutMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            //use a valid task id
            int taskId = 172;

            //request Task 5 from server
            ResponseObject responseObject = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, ResponseObject.class);

            //confirm data was retrieved & avoid NullPointerExceptions
            Task taskToUpdate;
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The task with ID " + taskId + " could not be found");
            } else {
                taskToUpdate = responseObject.getData();
            }

            //update the task information
            taskToUpdate.setName("updated using put() - video demo ");
            taskToUpdate.setDescription("this task was updated using RestTemplate's put() method - video demo");
            taskToUpdate.setCompleted(false);

            //use put to update the resource on the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(), taskToUpdate);
            //get the task to verify update
            responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, ResponseObject.class);
            System.out.println(responseObject.toString());

            taskToUpdate.setName("updated using exchange() PUT - video demo 2");
            taskToUpdate.setDescription("this task was updated using RestTemplate's exchange() method - video demo 2");

            //create an HttpEntity wrapping the task to update
            HttpEntity<Task> httpEntity = new HttpEntity<>(taskToUpdate);
            //use exchange() to PUT the HttpEntity, and map the response to a ResponseEntity
            ResponseEntity<ResponseObject> response = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(),
                    HttpMethod.PUT, httpEntity, ResponseObject.class);
            System.out.println(response.toString());

            //LBD

            String userEmail = "donald@trump.com";
            User userToUpdate;

            ResponseEntity<UserResponseObject> userResponseObjectResponseEntity = restTemplate.getForEntity(
                    "http://demo.codingnomads.co:8080/tasks_api/users?email=".concat(userEmail),
                    UserResponseObject.class
            );

            if (userResponseObjectResponseEntity.getStatusCode().equals(HttpStatus.OK) &
                userResponseObjectResponseEntity.getBody().getData() != null){
                userToUpdate = userResponseObjectResponseEntity.getBody().getData()[0];
            } else{
                throw new Exception("Couldn't get the user data");
            }

            userToUpdate.setFirst_name("Donald Jr");

            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/users/".concat(Long.toString(userToUpdate.getId())),
                    userToUpdate);


        };
    }
}
