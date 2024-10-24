package br.com.santander.santander_coders;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Informa ao Spring que esta classe é um controlador REST
public class HelloController {

    @GetMapping("/hello") //  Define que a URL /hello ao método helloWorld(), que retorna a string "Hello World".
    public HelloResponse helloWorld() {
        return new HelloResponse("Hello World");
    }
}
