package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.data.repositories.UserRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;

public class UserServicesImpl implements UserServices{
    private UserRepository userRepository = new UserRepositoryImpl();


    @Override
    public RegisterUserResponse register(RegisterUserRequests requestForm) {
        if (emailExists(requestForm.getEmailAddress())) throw new RegisterFailureException("Email is not used");
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());

        String name = requestForm.getFirstName() + requestForm.getLastName();
        String email = requestForm.getEmailAddress();
        String phoneNo = requestForm.getPhoneNumber();
        String address = requestForm.getAddress();

        User user = new User(email,name,phoneNo,address);





//        userRepository.save(user);

        User savedUser = userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setFullName(savedUser.getFullName());

        return response;
    }



    private boolean emailExists(String emailAddress){
        User user = userRepository.findByEmail(emailAddress);
        if (user != null) return true;
        return false;
    }

    @Override
    public  UserRepository getRepository(){
        return userRepository;
    }

    @Override
    public FindUserResponse findUserByEmail(String email) {
        email = email.toLowerCase();
        User user = userRepository.findByEmail(email);

        if(user == null) throw new UserNotFoundException(email + " not found");
        FindUserResponse response = new FindUserResponse();
        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());

        return response;
    }

}
