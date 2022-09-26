package com.example.restfull.restfull.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id ;
    
    @Column(unique = true)
   private String userName;
    
    
   private int userAge;

   @Temporal(TemporalType.TIMESTAMP)
   private Date createdDate;

    public Date getDate() {
        return createdDate;
    }

    public void setDate(Date date) {
        this.createdDate = date;
    }

    public int getUser_id() {
	return user_id;

   }

   public void setUser_id(int user_id) {
	this.user_id = user_id;

   }

   public String getUserName() {
	return userName;

   }

   public void setUserName(String userName) {
	this.userName = userName;

   }

   public int getUserAge() {
	return userAge;
	}

   public void setUserAge(int userAge) {
	this.userAge = userAge;

   }


}
