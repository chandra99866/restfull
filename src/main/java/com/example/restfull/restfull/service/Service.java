package com.example.restfull.restfull.service;


import com.example.restfull.restfull.entity.FilesEntity;
import com.example.restfull.restfull.entity.User;
import com.example.restfull.restfull.repos.FilesRepo;
import com.example.restfull.restfull.repos.Repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


    public String saveFile(MultipartFile file) throws IOException {

        Path path = Paths.get(file_path+file.getOriginalFilename());

        FilesEntity filesEntity = filesRepo.findByfileName(file.getOriginalFilename());
        Files.write(path,file.getBytes());

        if(filesEntity!=null){
            filesEntity.setFileSize(file.getSize());
            filesEntity.setUpdateDate(new Date());
            filesRepo.save(filesEntity);
            return "File replace successfully...";
        }
        else {

            FilesEntity filesEntity2 = new FilesEntity();
            filesEntity2.setFileName(file.getOriginalFilename());
            filesEntity2.setFileSize(file.getSize());
            filesEntity2.setUpdateDate(new Date());
            filesRepo.save(filesEntity2);
            return "File Save Successfully...";
        }

    }

    public List<FilesEntity> getAllFileNames(){
        return filesRepo.findAll();
    }

    public Resource getFile(String fileName) throws Exception {
        FilesEntity filesEntity = filesRepo.findByfileName(fileName);
        if(filesEntity!=null) {
            Path path = Paths.get(file_path+fileName);
            return new UrlResource(path.toUri());
        }
        return null;
    }


}
