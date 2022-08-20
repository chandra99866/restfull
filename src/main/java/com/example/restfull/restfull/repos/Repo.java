package com.example.restfull.restfull.repos;

import com.example.restfull.restfull.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<User,Integer> {
}
