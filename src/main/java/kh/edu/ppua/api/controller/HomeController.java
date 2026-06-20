package kh.edu.ppua.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Value("${ppua.api.env.profile}")
    String environmentProfile;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> home(){
        String ok = "Hi, PPUA \n Environment Profile : " + environmentProfile;
        return ResponseEntity.ok(ok);
    }
}
