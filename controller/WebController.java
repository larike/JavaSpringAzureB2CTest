package com.B2C.JavaB2C.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {

    @Autowired
    private Environment env;

    private void initializeModel(Model model, OAuth2AuthenticationToken token) {
        if (token != null) {
            final OAuth2User user = token.getPrincipal();
            model.addAttribute("grant_type", user.getAuthorities());
            model.addAllAttributes(user.getAttributes());
        }
    }

    @GetMapping(value = "/")
    public String index(Model model, OAuth2AuthenticationToken token) {
        initializeModel(model, token);

        return "home";
    }

    @GetMapping(value = "/greeting")
    public String greeting(Model model, OAuth2AuthenticationToken token) {
        initializeModel(model, token);

        return "greeting";
    }

    @GetMapping(value = "/home")
    public String home(Model model, OAuth2AuthenticationToken token) {
        initializeModel(model, token);

        return "home";
    }
}