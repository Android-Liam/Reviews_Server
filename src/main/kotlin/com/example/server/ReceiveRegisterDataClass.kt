package com.example.server

data class ReceiveRegisterDataClass(
    val name: String,
    val id: String,
    val password: String,
    val passwordCheck: String
)
