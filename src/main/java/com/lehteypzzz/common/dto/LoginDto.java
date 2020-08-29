package com.lehteypzzz.common.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * date: 2020/8/17 15:09
 *
 * @author pyethel
 */
@Data
public class LoginDto implements Serializable {

    @NotBlank(message="昵称不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
