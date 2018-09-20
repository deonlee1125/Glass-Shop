package com.example.glassshop.models.data;

import com.example.glassshop.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    public List<User> findByUsername(String username);

}
