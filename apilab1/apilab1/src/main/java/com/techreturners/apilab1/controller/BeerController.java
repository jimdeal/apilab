package com.techreturners.apilab1.controller;//package definition omitted for brevity
import com.techreturners.apilab1.model.Coffee;
import com.techreturners.apilab1.model.Beer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BeerController {
    private final AtomicLong counter = new AtomicLong();
    @GetMapping(value = "/beerlover")
    public String home(){
        return "I like beer!";
    }

    @GetMapping("/beer")
    public Beer beer(@RequestParam(value = "name", defaultValue =
            "leffe") String name) {
        return new Beer(counter.incrementAndGet(), name);
    }
}
