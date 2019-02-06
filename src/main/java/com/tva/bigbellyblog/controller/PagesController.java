package com.tva.bigbellyblog.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{locale:en|fr|pt}/")
public class PagesController {

  private static final Logger logger = LogManager.getLogger(PagesController.class.getName());

  @RequestMapping(method = RequestMethod.GET)
  public String getIndexPage() {
    logger.info("loading index locale page");
    return "index";
  }

  @RequestMapping(value = "post", method = RequestMethod.GET)
  public String getPostPage() {
    logger.info("loading post page");
    return "post";
  }

  @RequestMapping(value = "donation", method = RequestMethod.GET)
  public String getDonationPage() {
    logger.info("loading donation page");
    return "donation";
  }

  @RequestMapping(value = "list", method = RequestMethod.GET)
  public String getListPage() {
    logger.info("loading list page");
    return "list";
  }

  @RequestMapping(value = "postmain", method = RequestMethod.GET)
  public String getPostMainPage() {
    logger.info("loading postmain page");
    return "postmain";
  }
}
