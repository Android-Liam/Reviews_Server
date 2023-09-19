package com.example.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
@EntityScan(basePackages = ["com.example.server"])
@EnableJpaRepositories(basePackages = ["com.example.server"]) // JPA 리포지토리 패키지 명시
class DemoApplication

@Controller
class MainController {

	@GetMapping("/")
	fun main(): String {
		return "main"
	}
}

fun main(args: Array<String>) {
	// runApplication<DemoApplication>(*args)
	SpringApplication.run(DemoApplication::class.java, *args)
}