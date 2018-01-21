package com.easy.springboot.demo_servlet_filter_listener

import com.fasterxml.jackson.databind.ObjectMapper
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/HelloServlet"])
class HelloServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        println("===> 进入 HelloServlet doGet: req.requestURI = ${req.requestURI}")
        doPost(req, resp)
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        println("===> 进入 HelloServlet doPost: req.requestURI = ${req.requestURI}")

        var cookieStr = ""
        req.cookies.forEach {
            cookieStr += "${it.name}=${it.value};"
        }
        resp.contentType = "application/json;charset=UTF-8"

        var reqHeaders = hashMapOf<String, String>()
        req.headerNames.iterator().forEach {
            reqHeaders[it] = req.getHeader(it)
        }
        var resHeaders = hashMapOf<String, String>()
        resp.headerNames.forEach {
            resHeaders[it] = resp.getHeader(it)
        }
        val om = ObjectMapper()
        val resultJson = om.writeValueAsString(
                User(
                        username = "你好，World",
                        id = "10000000001",
                        cookie = cookieStr,
                        requestHeaders = reqHeaders,
                        responseHeaders = resHeaders
                )
        )
        val out = resp.writer
        println("HelloServlet 响应输出 ===> ${resultJson}")
        out.println(resultJson)
    }

    data class User(
            var username: String,
            var id: String,
            var cookie: String,
            var requestHeaders: Map<String, String>,
            var responseHeaders: Map<String, String>
    )

}





