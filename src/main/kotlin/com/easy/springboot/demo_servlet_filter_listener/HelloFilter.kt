package com.easy.springboot.demo_servlet_filter_listener

import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletResponse

@WebFilter(urlPatterns = ["/HelloServlet"])
class HelloFilter : Filter {
    override fun destroy() {
        println("===> 进入 HelloFilter 类 destroy 方法")
    }

override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
    //在这里可以对客户端请求进行处理
    println("===> 进入 HelloFilter doFilter")

    //沿过滤器链将请求传递到下一个过滤器
    chain.doFilter(request, response)

    //在这里可以对响应进行处理
    println("===> chain.doFilter 后执行 setToken(response) 方法")
    setToken(response)
}

    private fun setToken(response: ServletResponse) {
        val res = response as HttpServletResponse
        val token = MD5Util.md5("salt${System.currentTimeMillis()}")
        res.setHeader("Token", token)
    }

    override fun init(filterConfig: FilterConfig) {
        println("===> HelloFilter 类：${filterConfig.filterName}")
        println("===> 进入 HelloFilter 类 init 方法")
    }
}