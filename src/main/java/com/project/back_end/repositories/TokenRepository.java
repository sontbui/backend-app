package com.project.back_end.repositories;


import com.project.back_end.models.Role;
import com.project.back_end.models.Token;
import com.project.back_end.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findByUser(User user);
    Token findByToken(String token);
    Token findByRefreshToken(String token);
}

