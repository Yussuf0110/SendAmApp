package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryImplTest  {

    private UserRepository userRepository = new UserRepositoryImpl();


    @Test
    public void test_users_can_be_saved() {
        User aUser = new User("emailexists@gmail.com","John Doe", "08125531155","312,Sabo Road");
        userRepository.save(aUser);
        assertEquals(1,userRepository.count());


    }
    @Test
    public void testDelete_User() {
        User aUser = new User("emailexists@gmail.com","John Doe", "08125531155","312,Sabo Road");
        User aUser2 = new User("emailexistsok@gmail.com","John Doe", "08125531155","312,Sabo Road");
        User aUser3 = new User("emailexistsfor@gmail.com","John Doe", "08125531155","312,Sabo Road");
        userRepository.save(aUser);
        userRepository.save(aUser2);
        userRepository.save(aUser3);

        userRepository.delete(aUser);

        assertEquals(2,userRepository.count());
    }

    @Test
    public void testFindByEmail() {
        User aUser = new User("emailexists@gmail.com","John Doe", "08125531155","312,Sabo Road");
        User aUser2 = new User("emailexistsok@gmail.com","John Doe", "08125531155","312,Sabo Road");
        User aUser3 = new User("emailexistsfor@gmail.com","John Doe", "08125531155","312,Sabo Road");
        userRepository.save(aUser);
        userRepository.save(aUser2);
        userRepository.save(aUser3);

        User foundUser = userRepository.findByEmail("emailexists@gmail.com");
        assertEquals(aUser,foundUser);

    }

@Test
    public void testFindAllUsers() {
        User aUser = new User("emailexists@gmail.com","John Doe", "08125531155","312,Sabo Road");
        User aUser2 = new User("emailexistsok@gmail.com","John Doe", "08125531155","312,Sabo Road");
        User aUser3 = new User("emailexistsfor@gmail.com","John Doe", "08125531155","312,Sabo Road");
        userRepository.save(aUser);
        userRepository.save(aUser2);
        userRepository.save(aUser3);

        List<User> users =  userRepository.findAll();

        assertEquals(3,users.size());
    }
}