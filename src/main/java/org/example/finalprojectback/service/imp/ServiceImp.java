package org.example.finalprojectback.service.imp;

import jakarta.persistence.EntityNotFoundException;
import org.example.finalprojectback.entity.User;
import org.example.finalprojectback.repository.UserRepo;
import org.example.finalprojectback.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceImp implements UserService {
    private final UserRepo userRepo;



    public ServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
    }


    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepo.save(existingUser);
    }

    public void deleteUser(Long id) {
        if (!userRepo.existsById(id)) {
            throw new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + id);
        }
        userRepo.deleteById(id);
    }
}