package com.example.service.impl;

import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;

    @Test
    void deleteByUserName() {
//      userRepository.deleteByUserName("mikesmith@gmail.com");
        userService.deleteByUserName("mikesmith@gmail.com");
        verify(userRepository).deleteByUserName("mikesmith@gmail.com");
//        verify(userRepository,atLeastOnce()).deleteByUserName("mikesmith@gmail.com");
//        verify(userRepository,atLeast(5)).deleteByUserName("mikesmith@gmail.com");
//        verify(userRepository,atMostOnce()).deleteByUserName("mikesmith@gmail.com");
//        verify(userRepository,atMost(2)).deleteByUserName("mikesmith@gmail.com");

        InOrder inOrder=inOrder(userRepository);
        inOrder.verify(userRepository).deleteByUserName("mikesmith@gmail.com");
        inOrder.verify(userRepository).findAll();
    }
}