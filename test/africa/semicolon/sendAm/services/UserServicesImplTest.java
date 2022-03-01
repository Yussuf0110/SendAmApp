package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.PackageRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import africa.semicolon.sendAm.exceptions.SendAmAppException;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServicesImplTest {

    private UserServices userService = new UserServicesImpl();



    @Test
    public void afterRegister_repositoryContainsOneElement() {
        RegisterUserRequests registerForm = createRegisterMethod();
//        when
        userService.register(registerForm);
//        assert
        assertEquals(1,userService.getRepository().count());
    }


    private RegisterUserRequests createRegisterMethod() {
        RegisterUserRequests registerForm = new RegisterUserRequests();

        registerForm.setFirstName("Lota");
        registerForm.setLastName("Picker");
        registerForm.setEmailAddress("weAreAllIn@gmail.com");
        registerForm.setAddress("Cold Outside");
        registerForm.setPhoneNumber("2MillionDollars");
        return registerForm;
    }

    @Test
    public void duplicateEmail_throwsExceptionTest(){
        RegisterUserRequests lotaForm = createRegisterMethod();

//        when
            userService.register(lotaForm);

//            assert
        assertThrows(SendAmAppException.class, ()-> userService.register(lotaForm));

    }


    @Test
    public void duplicateEmailWithDifferentCase_throwsException(){
        RegisterUserRequests lotaForm = createRegisterMethod();

//        when
        userService.register(lotaForm);

//            assert
//        assertThrows(SendAmAppException.class, ()-> userService.register(lotaForm));
        assertThrows(RegisterFailureException.class, ()-> userService.register(lotaForm));

    }

    @Test
    public void registrationReturnsCorrectResponseTest(){
        RegisterUserRequests lotaForm = createRegisterMethod();
        RegisterUserResponse response = userService.register(lotaForm);
        assertEquals("LotaPicker",response.getFullName());
        assertEquals("weareallin@gmail.com",response.getEmail());



    }



}