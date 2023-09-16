package com.example.server

data class ResponseClass(
    val message: String, // 서버에서 받은 메시지
    val success: Boolean // 요청이 성공했는지 여부
)
