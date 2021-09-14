package com.example.productbackend.model.service;

import com.example.productbackend.model.entity.security.Account;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IAccountService {
    Account findAccountByUserName(String username);
    Integer findIdUserByUserName(String username);
    String existsByUserName(String username);
    Boolean existsById(Integer bookId);
    void addNew(String username, String password, String email) throws MessagingException, UnsupportedEncodingException;
    Boolean findAccountByVerificationCode(String code);
    Boolean findAccountByVerificationCodeToResetPassword(String code);
    void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException;
    /**
     * Hung DH - hien thi list
     */
    List<Account> getAllAccount();
    /**
     * LuyenNT code
     */
    void addNew(String username, String password);
    void saveNewPassword(String password,String code);
    /**
     * KhoaTA
     * Send info email to patient after register for a vaccination
     */
//    void sendInfoEmail(PeriodicalVaccinationTempRegisterDTO register, VaccinationHistory vaccinationHistory) throws MessagingException, UnsupportedEncodingException;
}
