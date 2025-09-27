package com.example.redisapp.service;

import com.example.redisapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    private static final String USER_KEY_PREFIX = "USER::";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveUser(User user) {
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getId(), user, 10, TimeUnit.MINUTES);
    }

    public User getUser(String id) {
        return (User) redisTemplate.opsForValue().get(USER_KEY_PREFIX + id);
    }
}
