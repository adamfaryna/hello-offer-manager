package org.jarfar.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Adam Faryna <a href="http://appdy.net">appdy.net</a>
 */
@Controller
public class WebController {

  @RequestMapping(value = "/")
  public String index() {
    return "index";
  }
}
