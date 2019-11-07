package com.monnet.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    
    @Autowired
    VersionNumberService versionNumberService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/")
    public String index() {
        return "Version Service is live. Use /api/compareVersions?sourceVersion=<xxx>&targetVersion=<xxx> to use the service";
    }

    @RequestMapping("/api/compareVersions")
    public String compareValues(@RequestParam String sourceVersion, @RequestParam String targetVersion) {
        String comparisonString = versionNumberService.compareVersions(sourceVersion, targetVersion);
        return comparisonString;
    }
}