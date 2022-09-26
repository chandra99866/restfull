package com.example.restfull.restfull.service;


import com.example.restfull.restfull.entity.User;
import com.example.restfull.restfull.repos.Repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@org.springframework.stereotype.Service
@Transactional
public class Service  {

    @Autowired
    Repo repo;

    @Transactional
    public int saveData(User user) throws Exception {
        if(repo.findExistOfuser(user.getUserName(),user.getUserAge())>0){
            throw new Exception("user already exists");
        }
        user.setDate(new Date());
        repo.save(user);
        return user.getUser_id();
    }




    public User getUserData(int id){
     try {
       User user = repo.findById(id).get();
       return user;
     }
       catch (Exception e) {
		return null;
	}
    }

    public List<User> getAllUserData(){
        return repo.findAll();
    }


}
