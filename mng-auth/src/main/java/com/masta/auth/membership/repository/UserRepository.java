package com.masta.auth.membership.repository;

import com.masta.auth.membership.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<BaseEntity, Long>{

}
