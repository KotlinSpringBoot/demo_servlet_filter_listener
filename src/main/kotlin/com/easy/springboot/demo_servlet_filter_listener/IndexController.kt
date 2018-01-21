package com.easy.springboot.demo_servlet_filter_listener

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {
    @GetMapping("/index")
    fun index(): String {
        return "INDEX"
    }
}