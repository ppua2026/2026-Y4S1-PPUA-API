package kh.edu.ppua.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> home(){
        String ok = "Hi, PPUA";
        return ResponseEntity.ok(ok);
    }
}
