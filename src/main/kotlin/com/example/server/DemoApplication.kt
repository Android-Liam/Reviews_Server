package com.example.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
class DemoApplication

@Controller
class MainController {

	@GetMapping("/")
	fun main(): String {
		return "main"
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}