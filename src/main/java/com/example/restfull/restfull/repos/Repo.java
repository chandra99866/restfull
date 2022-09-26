package com.example.restfull.restfull.repos;

import com.example.restfull.restfull.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repo extends JpaRepository<User,Integer> {

    @Query(value = "select count(*) from user a where user_name=?1 and user_age=?2",nativeQuery = true)
    int findExistOfuser(String userName,int age);
}
