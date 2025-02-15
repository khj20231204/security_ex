package com.cos.security_ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.security_ex.model.User;
import com.cos.security_ex.repository.UserRepository;


@Controller
public class IndexController {

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Autowired
   private UserRepository userRespository;
   
   @GetMapping({"","/"})
   public String index() {

       return "index";
   }

   @GetMapping("/user")
   public @ResponseBody String user(){
      return "user";
   }

   @GetMapping("/admin")
   public @ResponseBody String admin(){
      return "admin";
   }

   @PostMapping("/join")
   public String join(User user){
      System.out.println(user);

      String pwd = user.getPassword();
      user.setPassword(bCryptPasswordEncoder.encode(pwd));

      userRespository.save(user);

      return "redirect:loginForm";
   }

   @GetMapping("/joinForm")
   public String joinForm(){
      return "joinForm";
   }

   @GetMapping("/login")
   public @ResponseBody String login(){
      return "login";
   }

   @GetMapping("/loginForm")
   public String loginForm(){
      return "loginForm";
   }

   @GetMapping("/logout")
   public @ResponseBody String logout(){
      return "logout";
   }
   
   @GetMapping("/deleteUser")
   public @ResponseBody String deleteUser(){
      return "deleteUser";
   }
}
