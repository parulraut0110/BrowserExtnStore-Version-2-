package com.parul.BrowserExtnStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/store")
    public String index() {
        return "index"; 
    }
}
