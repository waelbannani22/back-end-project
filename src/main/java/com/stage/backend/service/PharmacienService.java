package com.stage.backend.service;

import com.stage.backend.entity.PasswordResetToken;
import com.stage.backend.entity.Pharmacien;
import com.stage.backend.repository.PasswordResetTokenRepository;
import com.stage.backend.repository.PharmacienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PharmacienService  implements IPharmarcienService{
    @Autowired
    PharmacienRepository pharmacienRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public Pharmacien registerPharmacien(Pharmacien pharmacien) {

       pharmacien.setPassword(passwordEncoder.encode(pharmacien.getPassword()));

       return pharmacienRepository.save(pharmacien);

    }

    @Override
    public void approveUser(Long idpharmacien) {


        Pharmacien pharmacien= pharmacienRepository.findById(idpharmacien).orElse(null);
        pharmacien.setIsActivated(true);
        pharmacienRepository.save(pharmacien);

    }

    @Override
    public void blockUser(Long idpharmacien) {
        Pharmacien pharmacien= pharmacienRepository.findById(idpharmacien).orElse(null);
        pharmacien.setIsActivated(false);
        pharmacienRepository.save(pharmacien);
    }

    @Override
    public void updatePharmacien(Pharmacien pharmacien) {
        Pharmacien pharmacien1= pharmacienRepository.findById(pharmacien.getId()).orElse(null);
        pharmacienRepository.save(pharmacien);

    }
    public Pharmacien findUserByEmail(String email) {
        return pharmacienRepository.findByEmail(email);
    }
    public void createPasswordResetTokenForUser(Pharmacien user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }
    public void updateUserPassword(Pharmacien user, String newPassword) {

        user.setPassword(passwordEncoder.encode(newPassword));
        pharmacienRepository.save(user);
    }
}
