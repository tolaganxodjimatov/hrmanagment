package uz.teasy.hrmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.teasy.hrmanagment.payload.*;
//import uz.teasy.hrmanagment.service.AuthService;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    AuthService authService;
//
//    @PostMapping("/registerUser")
//    public HttpEntity<?> registerUser(@RequestBody RegistrDTO registrDTO){
//        ApiResponse apiResponse = authService.registereUser(registrDTO);
//        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
//    }
//
//    @GetMapping("/verifyEmail")
//    public HttpEntity<?> verifyEmail(@RequestParam String emailCode,@RequestParam String email){
//        ApiResponse apiResponse = authService.verifyEmail(emailCode, email);
//        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
//    }
//
//    @PostMapping("/login")
//    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO){
//        ApiResponse apiResponse = authService.login(loginDTO);
//        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
//
//    }
//
//    @PreAuthorize("hasRole(ROLE_ADMIN_DIREKTOR)")
//    @PostMapping("/addManager")
//    public HttpEntity<?> addManager(@RequestBody ManagerDTO managerDTO){
//        ApiResponse apiResponse = authService.addManager(managerDTO);
//        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
//    }
//
//
//    @PostMapping("/addUser")
//    public HttpEntity<?> addUser(@RequestBody UserDTO userDTO){
//        ApiResponse apiResponse = authService.addUser(userDTO);
//        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
//    }
//
//}
