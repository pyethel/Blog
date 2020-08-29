package com.lehteypzzz.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * date: 2020/8/15 16:43
 *
 * @author pyethel
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;
}
