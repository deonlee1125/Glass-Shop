package com.example.glassshop.models.data;

import com.example.glassshop.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {

    public List<User> findByUsername(String username);
}
