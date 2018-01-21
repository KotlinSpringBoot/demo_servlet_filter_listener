package com.easy.springboot.demo_servlet_filter_listener

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener

@WebListener
class HelloListener: ServletContextListener {
    override fun contextInitialized(sce: ServletContextEvent) {
        println("===> HelloListener contextInitialized")
    }

    override fun contextDestroyed(sce: ServletContextEvent) {
        println("===> HelloListener contextDestroyed")
    }
}