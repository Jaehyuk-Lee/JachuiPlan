package com.trace.jachuiplan.home;

import com.trace.jachuiplan.user.CustomUserDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String root() {
        return "redirect:/map/";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/map")
    public String map() {
        return "redirect:/map/";
    }
}
