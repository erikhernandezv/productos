package com.ehernandez.inventory.persistence;

import com.ehernandez.inventory.domain.User;
import com.ehernandez.inventory.domain.repository.UserRepository;
import com.ehernandez.inventory.persistence.crud.UsuarioCrudRepository;
import com.ehernandez.inventory.persistence.entity.Usuario;
import com.ehernandez.inventory.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository{

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.toUsers((List<Usuario>) usuarioCrudRepository.findAll());
    }

    @Override
    public Optional<List<User>> getByNombres(String nombres) {
        return usuarioCrudRepository.findByNombres(nombres)
                .map(usuarios -> userMapper.toUsers(usuarios));
    }

    @Override
    public Optional<List<User>> getCargo(int cargoId) {
        return usuarioCrudRepository.findByIdCargo(cargoId)
                .map(usuarios -> userMapper.toUsers(usuarios));
    }

    @Override
    public Optional<User> getUser(int userId) {
        return usuarioCrudRepository.findById(userId).map(usuario -> userMapper.toUser(usuario));
    }

    @Override
    public User save(User user) {
        Usuario usuario = userMapper.toUsuario(user);
        return userMapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }
}
