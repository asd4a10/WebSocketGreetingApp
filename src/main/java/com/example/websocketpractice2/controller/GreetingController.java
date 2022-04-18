package com.example.websocketpractice2.controller;

import com.example.websocketpractice2.model.Greeting;
import com.example.websocketpractice2.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Hello, "+ HtmlUtils.htmlEscape(helloMessage.getName())+"!");
    }
}
