package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.List;

public interface UserRepository {
    User save(User aUser);
    User findByEmail(String email);
    List<User> findAll();
    void delete(User aUser);

    int count();
}
