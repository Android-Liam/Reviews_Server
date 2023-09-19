package com.example.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/*
MySQL과 연결하기 위한 코드
UserService.kt: 비즈니스 로직을 처리하기 위한 서비스 클래스
 */

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getAllUsers(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun getUserById(userIndex: Long): UserEntity? {
        return userRepository.findById(userIndex).orElse(null)
    }

    @Transactional
    fun createUser(user: UserEntity): UserEntity {
        println("UserService > createUser!")
        println("user : $user")
        return userRepository.save(user)
    }

    fun updateUser(userIndex: Long, updatedUser: UserEntity): UserEntity? {
        if (userRepository.existsById(userIndex)) {
            updatedUser.userIndex = userIndex
            return userRepository.save(updatedUser)
        }
        return null
    }

    fun deleteUser(userIndex: Long) {
        userRepository.deleteById(userIndex)
    }
}