package com.tva.bigbellyblog.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{locale:en|fr|pt}/")
public class PagesController {

  private static final Logger logger = LogManager.getLogger(PagesController.class.getName());

  @GetMapping
  public String getIndexPage() {
    logger.info("loading index locale page");
    return "index";
  }

  @GetMapping(value = "post")
  public String getPostPage() {
    logger.info("loading post page");
    return "post";
  }

  @GetMapping(value = "donation")
  public String getDonationPage() {
    logger.info("loading donation page");
    return "donation";
  }

  @GetMapping(value = "list")
  public String getListPage() {
    logger.info("loading list page");
    return "list";
  }

  @GetMapping(value = "postmain")
  public String getPostMainPage() {
    logger.info("loading postmain page");
    return "postmain";
  }

  @GetMapping(value = "manager")
  public String getManagerPage() {
    logger.info("loading manager page");
    return "manager";
  }
}
