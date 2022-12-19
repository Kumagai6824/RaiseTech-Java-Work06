package com.RaiseTech.Work06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

@RestController
public class GreetingTestController {
    
    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "hello world");
    }

    @GetMapping("/Greeting")
    public String test(
            @RequestParam(name = "country", value = "country", defaultValue = "none", required = false) String country,
            @RequestParam(name = "name", value = "name", defaultValue = "none", required = false) String name) {

        String greeting = "Hello world!";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        ZonedDateTime dateTime = ZonedDateTime.now();

        if (Objects.equals(country, "Japan")) {
            dateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
            greeting = "こんにちは！";
        } else if (Objects.equals(country, "USA")) {
            dateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
            greeting = "Hello!";
        } else if (Objects.equals(country, "Germany")) {
            dateTime = ZonedDateTime.now(ZoneId.of("Europe/Berlin"));
            greeting = "Guten tag!";
        }

        return "Country: " + country +
                "\nDate/Time: " + dateTime.format(timeFormatter) +
                "\nGreeting: " + greeting + "\s" + name;
    }

}
