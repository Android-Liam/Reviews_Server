package com.example.server

/*
App -> Server
Register Data Receive를 위한 Class
 */
data class ReceiveRegisterDataClass(
    val name: String,
    val id: String,
    val password: String,
    val passwordCheck: String
)
