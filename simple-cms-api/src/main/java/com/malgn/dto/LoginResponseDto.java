package com.malgn.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class LoginResponseDto {
    private String userId;
    private String userName;
    private String userRole;
}
