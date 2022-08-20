package com.example.restfull.restfull.service;


import com.example.restfull.restfull.entity.User;
import com.example.restfull.restfull.repos.Repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@org.springframework.stereotype.Service
@Transactional
public class Service  {

    @Autowired
    Repo repo;

    public int saveData(User user){
        repo.save(user);
        return user.getUser_id();
    }

    public User getData(int id){
     try {
       User user = repo.findById(id).get();
       return user;
     }
       catch (Exception e) {
		return null;
	}
    }


}
