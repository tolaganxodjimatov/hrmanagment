package uz.teasy.hrmanagment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class tmpClass {


    public static void main(String[] args) {


        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //Mega userga parol yasash uchun ishlatdim  - direktor
        String encode = passwordEncoder.encode("123");
        System.out.println("psw: "+encode);

        UUID uuid = UUID.randomUUID();
        System.out.println("id: "+uuid);

    }



}
