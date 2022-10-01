package com.example.restfull.restfull.service;


import com.example.restfull.restfull.entity.FilesEntity;
import com.example.restfull.restfull.entity.User;
import com.example.restfull.restfull.repos.FilesRepo;
import com.example.restfull.restfull.repos.Repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;


@org.springframework.stereotype.Service
@Transactional
public class Service  {


    @Value("${uploaded.files}")
    private String file_path;

    @Autowired
    Repo repo;

    @Autowired
    FilesRepo filesRepo;

    @Transactional
    public int saveData(User user) throws Exception {

        if(repo.findExistOfuser(user.getUserName(),user.getUserAge())>0){
            throw new Exception("user already exists");
        }
        user.setCreatedDate(new Date());
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


    public boolean saveFile(MultipartFile file) throws IOException {

        File file1 = new File(file_path+file.getOriginalFilename());
        file.transferTo(file1);
        FileWriter fw = new FileWriter(file1);
        fw.close();
        FilesEntity filesEntity = new FilesEntity();
        filesEntity.setFileName(file.getOriginalFilename());
        filesEntity.setFileSize(file.getSize());
        filesEntity.setUpdateDate(new Date());
        filesRepo.save(filesEntity);
        return true;
    }


}
