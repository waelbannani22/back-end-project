package com.stage.backend.config;

import com.stage.backend.entity.Pharmacien;
import com.stage.backend.repository.PharmacienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    PharmacienRepository pharmacienRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pharmacien user= pharmacienRepository.findByEmail(email);
        Optional<Pharmacien> op= Optional.of(user);
        return op.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));
    }
}
