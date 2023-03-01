package com.stage.backend.controller;

import com.stage.backend.entity.EmailDetails;
import com.stage.backend.entity.PasswordResetToken;
import com.stage.backend.entity.Pharmacien;
import com.stage.backend.repository.PasswordResetTokenRepository;
import com.stage.backend.service.EmailService;
import com.stage.backend.service.PharmacienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/managePassword")
public class ForgotPasswordController {

    @Autowired
    private PharmacienService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @PostMapping("/forgot-password/{email}")
    public ResponseEntity<?> processForgotPasswordForm(@PathVariable("email") String userEmail,
                                                       HttpServletRequest request) {
        try{
            System.out.println("m here");
            Pharmacien user = userService.findUserByEmail(userEmail);
            if (user == null) {
                return ResponseEntity.status(403).body("No user found with email " + userEmail);
            }

            // Generate password reset token and save it to the user
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token);

            // Send password reset email to the user
            String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            EmailDetails details = new EmailDetails();
            details.setRecipient(user.getEmail());
            details.setSubject("reset password");
            details.setAttachment("");
            details.setMsgBody("To reset your password, copy the code below:\n"+token);
            emailService.sendSimpleMail(details);
            HashMap<String, Object > re = new HashMap<>();
            re.put("message","le cle est envoye à"+userEmail);
            return ResponseEntity.ok().body(re);
        }catch (Exception e){
            throw e;
        }

    }
    //Confirm password
    @PostMapping("/confirm-password")
    public ResponseEntity<?> resetPassword(@RequestParam("token") String token,
                                           @RequestParam("password") String password) {

        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token);

        if (resetToken == null) {
            return ResponseEntity.badRequest().body("Invalid password reset token");
        }

        Pharmacien user = resetToken.getUser();

        // Check if the token has expired
        if (resetToken.getExpiryDate().before(new Date())) {
            return ResponseEntity.badRequest().body("Password reset token has expired");
        }

        // Update user password
        userService.updateUserPassword(user, password);

        // Delete the used password reset token
        passwordResetTokenRepository.delete(resetToken);
        HashMap<String, Object > re = new HashMap<>();
        re.put("message","mdp changé");
        return ResponseEntity.ok().body(re);
    }
}

