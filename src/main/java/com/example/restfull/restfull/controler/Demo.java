package com.example.restfull.restfull.controler;

import com.example.restfull.restfull.entity.User;
import com.example.restfull.restfull.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(originPatterns = "*",maxAge = 3600)
@RestController
@RequestMapping("/first")
public class Demo {

    @Autowired
    Service service;


    @GetMapping("/demo")
    public ResponseEntity<Object> demo(){
        Map<String,String> demo = new LinkedHashMap<>();
        demo.put("Access","GRANTED");
        demo.put("Demo","SUCCESS");
        demo.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> userSave(@RequestParam String name,@RequestParam int age){
        Map<String,String> result = new LinkedHashMap<>();
        User user = new User();
        user.setUserName(name);
        user.setUserAge(age);
        int status;
        try {
            status = service.saveData(user);
        }
        catch (Exception e){
            result.put("error",e.getLocalizedMessage());
            result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
        if(status>0){
            result.put("result","user added successfuly with user id : "+status);
            result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        else {
            result.put("Error","Either server problem or user problem");
            result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUser(@PathVariable int id){
        User user = service.getUserData(id);
        Map<String,Object> result = new LinkedHashMap<>();
        try {
            if (user != null) {
                result.put("userDetials", user);
                result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                result.put("error", "no user found");
                result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            result.put("error",e.getLocalizedMessage());
            result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getAllUsers(){
        LinkedHashMap<String,Object> result = new LinkedHashMap<>();
        try {
            result.put("users",service.getAllUserData());
            result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            return new ResponseEntity<>(result,HttpStatus.OK);

        }
        catch (Exception e){
            result.put("error",e.getLocalizedMessage());
            result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/saveFile")
    public ResponseEntity<Object> saveFile(@RequestPart MultipartFile file){
        LinkedHashMap<String,Object> result = new LinkedHashMap<>();

        try{
            service.saveFile(file);
            result.put("result","File Save");
            result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            return  new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            result.put("error",e.getLocalizedMessage());
            result.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
