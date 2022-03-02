package africa.semicolon.sendAm.controllers;

import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.services.UserServices;
import africa.semicolon.sendAm.services.UserServicesImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {
    private UserServices userService = new UserServicesImpl();

    @PostMapping("/register")

    public RegisterUserResponse registerNewUser(RegisterUserRequests request){
        return userService.register(request);
    }

    @GetMapping("/{email}")

    public FindUserResponse getUserByEmail(String email){
        return userService.findUserByEmail(email);
    }
}
