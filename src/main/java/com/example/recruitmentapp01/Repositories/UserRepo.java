package com.example.recruitmentapp01.Repositories;

import com.example.recruitmentapp01.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    public User findUserByName(String name);


}
