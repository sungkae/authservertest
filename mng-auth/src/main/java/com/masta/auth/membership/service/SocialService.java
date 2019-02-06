package com.masta.auth.membership.service;

import com.masta.auth.membership.dto.SocialUserForm;
import com.masta.auth.membership.entity.SocialUser;
import com.masta.auth.membership.repository.SocialRepository;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SocialService {
    private final SocialRepository socialRepository;

    @Transactional
    public SocialUser getOrSave(SocialUserForm socialUserForm) {
        SocialUser newUser = new SocialUser();
        Optional<SocialUser> saveUser = socialRepository.findBySocialId(socialUserForm.getSocial_id());
        if(!saveUser.isPresent()) {
            newUser = socialUserForm.toEntity();
            newUser = socialRepository.save(newUser);
        }

        return newUser;
    }
}
