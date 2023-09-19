package com.example.server

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/*
App -> Server
Register Data Receive를 위한 Class
 */

@RestController
@RequestMapping("/api")
class DataController {

    @PostMapping("/data")
    fun receiveData(@RequestBody data: ReceiveRegisterDataClass): ResponseEntity<ResponseClass> {
        // 데이터 로깅
        println("Received data from Android app:")
        println("Nickname: ${data.name}\nID: ${data.id}\nPassword: ${data.password}\nPassword: ${data.passwordCheck} ")

        // 데이터 처리 및 응답 생성
        val response = ResponseClass("Data received successfully", true)
        return ResponseEntity.ok(response)
    }
}
