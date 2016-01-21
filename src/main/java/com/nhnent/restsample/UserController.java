package com.nhnent.restsample;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  
  @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
  public Object showUserInfo(@PathVariable(value = "username") String username, HttpServletRequest  request, HttpServletResponse response) {
    
    /*
     * user_id로 유저 찾기 
     */
    
    logger.info("@@@@ USER_ID @@@@@"+username);
    
    User user = new User();
    user.setId(1);
    user.setUsername(username);

    return user;
    
  }
}
