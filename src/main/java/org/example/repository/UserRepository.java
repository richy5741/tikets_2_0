package org.example.repository;

import org.example.domain.User;

public interface UserRepository {
    void save(User user);
    User selectUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
