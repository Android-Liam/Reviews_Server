package com.example.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/*
MySQL과 연결하기 위한 코드
UserController.kt: API 엔드포인트를 정의하는 컨트롤러 클래스
 */

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/")
    fun getAllUsers(): List<UserEntity> {
        return userService.getAllUsers()
    }

    @GetMapping("/{userIndex}")
    fun getUserById(@PathVariable userIndex: Long): UserEntity? {
        return userService.getUserById(userIndex)
    }

    @PostMapping("/")
    fun createUser(@RequestBody user: UserEntity): UserEntity {
        return userService.createUser(user)
    }

    @PutMapping("/{userIndex}")
    fun updateUser(@PathVariable userIndex: Long, @RequestBody updatedUser: UserEntity): UserEntity? {
        return userService.updateUser(userIndex, updatedUser)
    }

    @DeleteMapping("/{userIndex}")
    fun deleteUser(@PathVariable userIndex: Long) {
        userService.deleteUser(userIndex)
    }
}