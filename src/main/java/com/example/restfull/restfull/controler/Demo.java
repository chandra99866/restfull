package com.example.restfull.restfull.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/first")
public class Demo {


    @GetMapping("/demo")
    public ResponseEntity<Object> demo(){
        Map<String,String> demo = new HashMap<>();
        demo.put("Access","GRANTED");
        demo.put("Demo","SUCCESS");
        demo.put("Time", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }
}
