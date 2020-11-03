package com.chris.my.shop.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dto.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbUser extends BaseEntity {
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;

}

