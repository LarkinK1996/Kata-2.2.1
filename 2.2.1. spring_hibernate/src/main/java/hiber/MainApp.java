package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car(123, "bmv");
        Car car2 = new Car(123, "dodge");

        User user1 = new User("Ivan", "Ivanov", "ivan@mail.ru");
        User user2 = new User("Vladimir", "Vasiliev", "vladimir@mail.ru");

        user1.setCar(car1);
        user2.setCar(car2);

        userService.add(user1);
        userService.add(user2);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        System.out.println(userService.getUser(123, "bmv"));

        context.close();
    }
}

