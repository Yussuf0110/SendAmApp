package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;

public interface UserServices {
        RegisterUserResponse register(RegisterUserRequests requestForm);

        UserRepository getRepository();

        FindUserResponse findUserByEmail(String email);
}
