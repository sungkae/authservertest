package com.masta.auth.membership.controller;

import com.masta.auth.membership.entity.AccountUser;
import com.masta.auth.membership.repository.UserRepository;
import com.masta.auth.membership.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/member")
public class MembershipController {

    @Autowired
    AccountService accountService;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @GetMapping("/{id}/{pw}")
    public void Logintest(@PathVariable String id, @PathVariable String pw) {
        AccountUser accountUser = AccountUser.builder()
                .password(pw)
                .username(id)
                .build();
        accountService.createUser(accountUser);
    }
}

