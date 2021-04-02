package com.bingo.springcloud.controller;

import com.bingo.springcloud.entities.kafka.Greetings;
import com.bingo.springcloud.service.GreetingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author:yaobin
 * @date:2021/3/23,23:57
 */

@RestController
@Slf4j
public class GreetingsController {

    private final GreetingsService greetingsService;
    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }
    
    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("message")String message){
        Greetings greetings = Greetings.builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
        greetingsService.sendGreetings(greetings);

    }
}
