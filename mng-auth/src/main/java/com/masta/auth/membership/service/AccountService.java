package com.masta.auth.membership.service;

import com.masta.auth.membership.entity.AccountUser;
import com.masta.auth.membership.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountUser accountUser = accountRepository.findByUsername(username);
        accountUser.setAuthorities(accountUser.getAuthorities());

        return accountUser;
    }

    public void createUser(AccountUser accountUser) {
        String pw = accountUser.getPassword();
        String encodedPw = new BCryptPasswordEncoder().encode(pw);
        accountUser.setPassword(encodedPw);
        accountUser.setAuthority("ROLE_USER");
        accountRepository.save(accountUser);
    }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }

}
