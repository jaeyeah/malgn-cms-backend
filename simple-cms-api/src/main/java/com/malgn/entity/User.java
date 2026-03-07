package com.malgn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "user_name", nullable = false, unique = true, length = 30)
    private String userName;

    @Column(name = "user_password", nullable = false, length = 100)
    private String userPassword;

    @Column(name = "user_role", nullable = false, length = 20)
    private String userRole;
    
}
