package com.nhnent.restsample;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhnent.user.User;


@RestController
public class UserController {
  
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);
  
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public Object showUser(HttpServletResponse response, @RequestParam("response") String idx) {
    
    return "profile";
  }
  
//  @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
  @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
  public Object showUserInfo(@PathVariable(value = "username") String username, @RequestParam("user_id")String user_id, HttpServletRequest  request, HttpServletResponse response) {
    
    /*
     * user_id로 유저 찾기 
     */
    
    logger.debug("@@@@ USER_ID @@@@@"+user_id);
    
    User user = new User();
    user.setId(1);
    user.setUsername("sangwoo");
    
    
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.add("code", "200");
    parameters.add("user_name", "ssang1105");
    parameters.add("email", "ssang1105@live.co.kr");
    

    return user;
    
  }
}
