package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class AboutPage implements About{

    @Override
    public String getAbout() {
        return "Welcome to Joe's Computer Shack, your one-stop shop for all your computing needs! At Joe's, we specialize in providing high-quality computers and all the essential parts needed to build your perfect machine.";
    }
}
