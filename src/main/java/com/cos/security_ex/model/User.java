package com.cos.security_ex.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
   
   @Id @GeneratedValue
   private int id;
   private String username;
   private String password;
   private String role;

   @CreationTimestamp
   private Timestamp createId;
}
