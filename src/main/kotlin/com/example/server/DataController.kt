package com.example.server

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.client.RestTemplate

/*
App -> Server
Register Data Receive를 위한 Class
 */

@RestController
@RequestMapping("/api")
class DataController {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Autowired
    private lateinit var userService: UserService

    @PostMapping("/data")
    fun receiveData(@RequestBody data: ReceiveRegisterDataClass): ResponseEntity<ResponseClass> {
        // 데이터 로깅
        println("Received data from Android app:")
        println("Nickname: ${data.name}\nID: ${data.id}\nPassword: ${data.password}\nPassword: ${data.passwordCheck} ")

        // 새로운 사용자 엔티티 생성
        val newUser = UserEntity(
            name = data.name,
            id = data.id,
            pwd = data.password,
            spicinessLevel = 1,
            portionSize = 1,
            tasteSensitivity = 1
        )

        // UserService를 사용하여 사용자를 생성
        userService.createUser(newUser)

        // 데이터 처리 및 응답 생성
        val response = ResponseClass("Data received successfully", true)
        return ResponseEntity.ok(response)
    }
}
