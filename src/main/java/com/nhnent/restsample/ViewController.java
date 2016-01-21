package com.nhnent.restsample;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nhnent.user.User;


@Controller
public class ViewController {
  
  private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
  
  @RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
  public Object showProfileView(HttpServletResponse response, @PathVariable(value = "username") String username,  Model model ) {

    
    final String requestUrl = "http://localhost:8080/restsample/users/" + username;

    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(requestUrl)
        .queryParam("user_id", "ssang1105");
    RestTemplate restTemplate = new RestTemplate();
    User user = restTemplate.getForObject(uriBuilder.build().toUri(), User.class);
    
    
    logger.info("RESPONSE!!!!!!" + user);
    
    model.addAttribute("user_id", user.getId());
    model.addAttribute("user_name", user.getUsername());
    
    return "profile";
  }


}
