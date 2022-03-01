package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.data.repositories.UserRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;

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



//        user.setFullName(requestForm.getFirstName() + requestForm.getLastName());
//        user.setAddress(requestForm.getAddress());
//        user.setPhoneNumber(requestForm.getPhoneNumber());
//        user.setEmail(requestForm.getEmailAddress());

        userRepository.save(user);

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


}
