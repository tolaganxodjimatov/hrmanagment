package uz.teasy.hrmanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.teasy.hrmanagment.entity.UserEmployee;
import uz.teasy.hrmanagment.entity.enums.RoleEnum;
import uz.teasy.hrmanagment.payload.*;
import uz.teasy.hrmanagment.repository.RoleRepository;
import uz.teasy.hrmanagment.repository.UserEmployeeRepository;
import uz.teasy.hrmanagment.security.JwtProvider;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

//@Service
//public class AuthService implements UserDetailsService {
//    @Autowired
//    UserEmployeeRepository userEmployeeRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Autowired
//    RoleRepository roleRepository;
//    @Autowired
//    JavaMailSender javaMailSender;
//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Autowired
//    JwtProvider jwtProvider;
//
//
//    public ApiResponse registereUser(RegistrDTO registrDTO) {
//        boolean existsByEmail = userEmployeeRepository.existsByEmail(registrDTO.getEmail());
//        if (existsByEmail)
//            return new ApiResponse("User with this email already exists!", false, null);
//        UserEmployee user = new UserEmployee();
//        user.setFullName(registrDTO.getFullName());
//        user.setEmail(registrDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(registrDTO.getPassword()));
//
//        user.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleEnum.ROLE_USER_EMPLOYEE)));
//        user.setEmailCode(UUID.randomUUID().toString());
//        userEmployeeRepository.save(user);
//        //Emailga jonatish metodini chaqiramiz
//        sendEmail(user.getEmail(), user.getEmailCode());
//
//        return new ApiResponse("OK saved", true, null);
//    }
//
//    public Boolean sendEmail(String sendingEmail, String emailCode) {
//        try {
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setFrom("Test@mrtg.com");
//            mailMessage.setTo(sendingEmail);
//            mailMessage.setSubject("Akauntingizni tasdiqlash yuzasidan");
//            mailMessage.setText(
//                    "<a href='http://localhost:8080/api/auth/verifyEmail?emailCode=" + emailCode
//                            + "&email=" + sendingEmail + "'>Tasdiqlang</a>");
//
//            javaMailSender.send(mailMessage);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public ApiResponse verifyEmail(String emailCode, String email) {
//        Optional<UserEmployee> optionalUser = userEmployeeRepository.findByEmailAndEmailCode(email, emailCode);
//        if (optionalUser.isPresent()) {
//            UserEmployee user = optionalUser.get();
//            user.setEnabled(true);
//            user.setEmailCode(null);
//            userEmployeeRepository.save(user);
//            return new ApiResponse("Akkaunt tasqilandi", true);
//        }
//        return new ApiResponse("Akkaunt allaqachon tasqilangan yoki nimadur hato ketti", false);
//    }
//
//    public ApiResponse login(LoginDTO loginDTO) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    loginDTO.getEmail(),
//                    loginDTO.getPassword()
//            ));
//            UserEmployee user = (UserEmployee) authentication.getPrincipal();
//            String token = jwtProvider.generateToken(loginDTO.getEmail(), user.getRoles());
//            return new ApiResponse("Token: ", true, token);
//
//        } catch (BadCredentialsException e) {
//            return new ApiResponse("Parol ili Login xato", false);
//        }
//
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserEmployee> optionalUser = userEmployeeRepository.findByEmail(username);
//        if (optionalUser.isPresent()) return optionalUser.get();
//        throw new UsernameNotFoundException(username + " topilmadi");
//    }
//
//
//    public ApiResponse addManager(ManagerDTO managerDTO) {
//        // shu yerda amaliyot bajarishdan oldin
//        // token ichida kelgan foydalanuvchini ili hozirda royhatdan otib turgan foydalanuvchini ushlash kk
//
////        SecurityContextHolder.getContext().
////        jwtProvider.getEmailFromToken()
////        KimYozganBilish kimYozganBilish = new KimYozganBilish(); // user ID qaytaradi
////        System.out.println(kimYozganBilish.toString()+"------------------------");
////        boolean existsById = userEmployeeRepository.existsById(kimYozganBilish.getCurrentAuditor().get());
////        System.out.println("existsById " + existsById + " -- " + userEmployeeRepository.existsById(kimYozganBilish.getCurrentAuditor().get()));
//
//
//        boolean existsByEmail = userEmployeeRepository.existsByEmail(managerDTO.getEmail());
//        if (existsByEmail) return new ApiResponse("User with this email already exists!", false, null);
//        UserEmployee user = new UserEmployee();
//        user.setFullName(managerDTO.getFullName());
//        user.setEmail(managerDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(managerDTO.getPassword()));
//        user.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleEnum.ROLE_MODER_HR_MANAGER)));
//        user.setEmailCode(UUID.randomUUID().toString());
//        userEmployeeRepository.save(user);
//        //Emailga jonatish metodini chaqiramiz
//        sendEmail(user.getEmail(), user.getEmailCode());
//        return new ApiResponse("OK saved", true, null);
//
//    }
//
//
//    public ApiResponse addUser(UserDTO userDTO) {
//        boolean existsByEmail = userEmployeeRepository.existsByEmail(userDTO.getEmail());
//        if (existsByEmail) return new ApiResponse("User with this email already exists!", false, null);
//        UserEmployee user = new UserEmployee();
//        user.setFullName(userDTO.getFullName());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//        user.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleEnum.ROLE_USER_EMPLOYEE)));
//        user.setEmailCode(UUID.randomUUID().toString());
//        userEmployeeRepository.save(user);
//        //Emailga jonatish metodini chaqiramiz
//        sendEmail(user.getEmail(), user.getEmailCode());
//
//        return new ApiResponse("OK saved", true, null);
//
//
//    }
//}
















