package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController {

    @RequestMapping
    fun Welcome(): String {
        return "Hello !"
    }
}