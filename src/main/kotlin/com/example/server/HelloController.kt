package com.example.server

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SignUpController {

    @GetMapping("/signup")
    fun signup(): String {
        return "signup"
    }
}