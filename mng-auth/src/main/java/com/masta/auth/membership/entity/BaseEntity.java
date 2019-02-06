package com.masta.auth.membership.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@DiscriminatorColumn(name="type")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long num;
    private String authority;

    private String nickname;
}
