package com.clicdirectory.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by rishabh
 */
@Controller
@RequestMapping("/")
public class NonAPIController extends BaseController {
    private static final Logger logger = Logger.getLogger(NonAPIController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public
    @ResponseBody
    String testControllerMethod(ModelMap model) {
        logger.info("Test call!");
        return "Test successful!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test/git")
    public
    @ResponseBody
    String gitServletCallControllerMethod(ModelMap model) {
        logger.info("Git Controller call!");

        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("git.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
        }
        String gitInfoString = "";
        gitInfoString += "<table border=1 >";
        gitInfoString += "<tr><th><pre>git.commit.id</pre></th><td><pre>" + properties.getProperty("git.commit.id.abbrev", "NA") + "</pre></td></tr>";
        gitInfoString += "<tr><th><pre>git.build.time</pre></th><td><pre>" + properties.getProperty("git.build.time", "NA") + "</pre></td></tr>";
        gitInfoString += "<tr><th><pre>git.commit.message</pre></th><td><pre>" + properties.getProperty("git.commit.message.short", "NA") + "</pre></td></tr>";
        gitInfoString += "<tr><th><pre>git.commit.time</pre></th><td><pre>" + properties.getProperty("git.commit.time", "NA") + "</pre></td></tr>";
        gitInfoString += "</table><br>";

        return gitInfoString;
    }
}
