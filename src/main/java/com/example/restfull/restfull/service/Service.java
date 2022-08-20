package com.example.restfull.restfull.service;


import com.example.restfull.restfull.entity.User;
import com.example.restfull.restfull.repos.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@org.springframework.stereotype.Service
public class Service  {

    @Autowired
    Repo repo;

    public int saveData(User user){
        repo.save(user);
        return user.getUser_id();
    }


}
