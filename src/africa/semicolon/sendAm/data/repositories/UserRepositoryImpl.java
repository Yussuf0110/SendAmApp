package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> usersList = new ArrayList<>();
    private int id;

    @Override
    public User save(User aUser) {
        usersList.add(aUser);
        return aUser;
    }

    @Override
    public void delete(User aUser) {
        usersList.remove(aUser);

    }

    @Override
    public int count() {
        return usersList.size();
    }


    @Override
    public User findByEmail(String email) {
        for (User user : usersList) {
            if (user.getEmail().equals( email))
                return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return usersList;
    }

}
