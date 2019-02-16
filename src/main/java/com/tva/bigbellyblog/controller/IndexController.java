package com.tva.bigbellyblog.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

  private static final Logger logger = LogManager.getLogger(IndexController.class.getName());

  @GetMapping
  public String getIndexPage() {
    logger.info("loading index page");
    return "redirect:en/";
  }

}
