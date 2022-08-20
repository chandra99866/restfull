package com.example.restfull.restfull.controler;

import com.example.restfull.restfull.entity.User;
import com.example.restfull.restfull.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/first")
public class Demo {

    @Autowired
    Service service;


    @GetMapping("/demo")
    public ResponseEntity<Object> demo(){
        Map<String,String> demo = new HashMap<>();
        demo.put("Access","GRANTED");
        demo.put("Demo","SUCCESS");
        demo.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> userSave(@RequestParam String name,@RequestParam int age){
        Map<String,String> result = new HashMap<>();
        User user = new User();
        System.out.println(age);
        user.setUserName(name);
        user.setUserAge(age);
        int status = service.saveData(user);
        if(status>0){
            result.put("result","user added successfuly");
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        else {
            result.put("Error","Either server problem or user problem");
            return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
