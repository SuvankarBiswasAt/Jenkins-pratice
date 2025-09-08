package com.shiv.user.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@ToString
public class User {

    private Integer userId;

    private String userName;

    private String userUUID;

}
