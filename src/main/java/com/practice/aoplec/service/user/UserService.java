package com.practice.aoplec.service.user;

import com.practice.aoplec.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();
}
