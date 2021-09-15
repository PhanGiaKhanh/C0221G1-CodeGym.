package com.example.productbackend.controller;

import com.example.productbackend.jwt.JwtUtility;
import com.example.productbackend.model.entity.security.Account;
import com.example.productbackend.model.entity.security.reponse.JwtResponse;
import com.example.productbackend.model.entity.security.request.LoginRequest;
import com.example.productbackend.model.service.IAccountService;
import com.example.productbackend.model.service.IRoleService;
import com.example.productbackend.model.service.imple.security.AccountDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        AccountDetailsImpl userDetails = (AccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        Account account = accountService.findAccountByUserName(loginRequest.getUsername());
//        Patient patient = patientService.findByAccountId(account.getAccountId(), false);

//        if (patient != null) {
//            patient.setAccount(null);
//        }

        return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        roles)
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) throws MessagingException, UnsupportedEncodingException {
        if (accountService.existsById(signUpRequest.getBookId())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Mã số sổ  đã được đăng ký!!!"));
        }
        if (accountService.existsByUserName(signUpRequest.getEmail()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email đã được đăng ký!!!"));
        }

        // Create new user's account
        Account account = new Account(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        //Add new user's account to database
        accountService.addNew(account.getUserName(), account.getEncryptPw(), signUpRequest.getEmail());
        //Find ID user's account newest after add to database
        Integer idAccountAfterCreated = accountService.findIdUserByUserName(account.getUserName());
        //Set default role is "ROLE_USER"
        roleService.setDefaultRole(idAccountAfterCreated, 1);
        //Add new patient
        patientService.addPatient(
                signUpRequest.getName(),
                signUpRequest.getDateOfBirth(),
                signUpRequest.getGender(),
                signUpRequest.getGuardian(),
                signUpRequest.getPhone(),
                signUpRequest.getAddress(),
                signUpRequest.getEmail(), idAccountAfterCreated, false);
        return ResponseEntity.ok(new MessageResponse("Đăng ký tài khoản thành công!"));
    }

    @PostMapping("/verify")
    public ResponseEntity<?> VerifyEmail(@RequestBody VerifyRequest code) {
        Boolean isVerified = accountService.findAccountByVerificationCode(code.getCode());
        if (isVerified) {
            return ResponseEntity.ok(new MessageResponse("activated"));
        } else {
            return ResponseEntity.ok(new MessageResponse("error"));
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> reset(@RequestBody LoginRequest loginRequest) throws MessagingException, UnsupportedEncodingException {

        if (accountService.existsByUserName(loginRequest.getUsername()) != null) {
            accountService.addVerificationCode(loginRequest.getUsername());
            return ResponseEntity.ok(new MessageResponse("Sent email "));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không đúng"));
    }

    @PostMapping("/verify-password")
    public ResponseEntity<?> VerifyPassword(@RequestBody VerifyRequest code) {
        Boolean isVerified = accountService.findAccountByVerificationCodeToResetPassword(code.getCode());
        if (isVerified) {
            return ResponseEntity.ok(new MessageResponse("accepted"));
        } else {
            return ResponseEntity.ok(new MessageResponse("error"));
        }
    }

    @PostMapping("/do-reset-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPassRequest resetPassRequest) {
        accountService.saveNewPassword(encoder.encode(resetPassRequest.getPassword()), resetPassRequest.getCode());
        return ResponseEntity.ok(new MessageResponse("success"));
    }

}