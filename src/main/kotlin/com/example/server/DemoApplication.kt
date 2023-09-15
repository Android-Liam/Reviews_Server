package com.example.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@SpringBootApplication
class DemoApplication

@Controller
class HelloController {
	@GetMapping("/hello")
	fun hello(): ModelAndView {
		return ModelAndView("hello")
	}
}

@Controller
class MessageController {
	@GetMapping("/")
	fun index(@RequestParam("name") name: String): ModelAndView {
		val model = ModelAndView("message")
		model.addObject("message", "Hello, $name!")
		return model
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
