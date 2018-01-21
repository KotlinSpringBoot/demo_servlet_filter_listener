package com.easy.springboot.demo_servlet_filter_listener

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@EnableAutoConfiguration(exclude = [ErrorMvcAutoConfiguration::class]) // exclude, 有异常不会找默认error页面了，而是直接输出字符串
@ServletComponentScan
class DemoServletFilterListenerApplication

fun main(args: Array<String>) {
    runApplication<DemoServletFilterListenerApplication>(*args)
}

//@ServletComponentScan
//* Enables scanning for Servlet components (
// {@link WebFilter filters},
// {@link WebServlet servlets}, and
// {@link WebListener listeners}). Scanning is only performed when using an
//* embedded web server.