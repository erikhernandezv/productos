package com.ehernandez.inventory.domain.repository;

import com.ehernandez.inventory.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Optional<List<User>> getByNombres(String nombres);
    Optional<List<User>>getCargo(int cargoId);
    Optional<User> getUser(int userId);
    User save(User user);
    void delete(int userId);
}
