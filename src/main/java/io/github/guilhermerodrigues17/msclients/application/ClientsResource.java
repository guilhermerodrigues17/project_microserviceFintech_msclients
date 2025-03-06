package io.github.guilhermerodrigues17.msclients.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class ClientsResource {

    @GetMapping
    public String status() {
        return "OK!";
    }
}
