package com.jaemin.springbootstudy.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "이메일을 입력해주세요.")
        @Email(message = "이메일 형식으로 입력해주세요.")
        String email,

        @NotBlank(message = "이름을 입력해주세요.")
        @Size(max = 10, message = "이름은 10자까지만 입력해주세요.")
        String name
) {
}
