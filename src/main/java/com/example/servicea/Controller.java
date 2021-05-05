package com.example.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
public class Controller {

    @Autowired
    private RestTemplate template;

    @Value("${REPLY:mm?}")
    private String reply;

    @GetMapping(path = "/a")
    public String response(){
        return "Service A (Public) 5.2.1:" + reply;
    }

    @GetMapping(path = "/ab")
    public String responseFromB(){
        return template.getForEntity("http://service-b/b", String.class).getBody();
    }

}

