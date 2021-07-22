package com.example.sibal.repository;

import com.example.sibal.domain.Cart;
import com.example.sibal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CartRepositroy extends JpaRepository<Cart,Long> {
    List<Cart> findByUser(User user);
}