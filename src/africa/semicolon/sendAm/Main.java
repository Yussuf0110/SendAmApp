package africa.semicolon.sendAm;

import africa.semicolon.sendAm.controllers.UserController;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

    @SpringBootApplication
public class Main {
    public static UserController userController = new UserController();
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);                                                                                                                                                                                                                                                                                                                                                                                                             

//        Load options
//        loadOptions();
//        if option is register
//        load form
//        print output
//        load options
//
//        if option is search by email
//        ask for email
//        show
//        load options




    }

    private static void loadOptions() {
        String option = """
                -> A for Register
                -> B for Find by email
                """;
        display(option);
        String input = collectStringInput(option);
        switch (input.toLowerCase()) {
            case "a" -> loadRegisterForm();
            case "b" -> askUserForEmail();
            default -> {
                display("get sense");
                loadOptions();
            }
        }

    }

    private static void askUserForEmail() {
        String userEmail = collectStringInput("Enter the email you want to search");
        var response = userController.getUserByEmail(userEmail);
        display(response.toString());
        loadOptions();

    }

    private static void loadRegisterForm() {
        RegisterUserRequests form = new RegisterUserRequests();
            form.setFirstName(collectStringInput("Enter your first name"));
            form.setLastName(collectStringInput("Enter your last name"));
            form.setEmailAddress(collectStringInput("Enter your email address"));
            form.setAddress(collectStringInput("Enter your address"));
            form.setPhoneNumber(collectStringInput("Enter your phone number"));

        RegisterUserResponse response = userController.registerNewUser(form);
        display(response.toString());
    }

    private static String collectStringInput(String message) {
        Scanner scanner = new Scanner(System.in);
        display(message);
        return scanner.nextLine();

    }

    private static void display(String message) {
        System.out.print(message);
    }
}
