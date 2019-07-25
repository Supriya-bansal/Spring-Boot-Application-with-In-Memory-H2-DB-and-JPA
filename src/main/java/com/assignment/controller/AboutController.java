package com.assignment.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.constants.MessageConstants;



/**
 * @author supu
 * This controller is created for informational purpose only. 
 * This will be extended to serve information about any additional apis that maybe added later.
 */

@RestController
public class AboutController {

	@GetMapping(value= "/")
	public void redirectToAboutPage(HttpServletResponse response) throws IOException {
		response.sendRedirect(MessageConstants.LINK_TO_ABOUT);
	}
	
	@GetMapping("member-api/v1/members/about")
	  public String getInfo(){
	  return "This is yet to come. For more details, Please visit Documentation : https://github.com/Supriya-bansal/Spring-Boot-Application-with-In-Memory-H2-DB-and-JPA";
	  }
}
