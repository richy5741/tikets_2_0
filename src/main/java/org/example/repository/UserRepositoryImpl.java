package org.example.repository;
import org.example.domain.User;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository, UserCounter {
    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User selectUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }

    // METODO ADICIONAL QUE PIDE EL PROFE
    @Override
    public int countUsers() {
        return users.size();
    }
}
