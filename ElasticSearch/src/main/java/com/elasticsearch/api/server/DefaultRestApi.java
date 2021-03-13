package com.elasticsearch.api.server;



import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultRestApi {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
			
	@GetMapping("/welcome")
	public String welcome(){
		return "Olá";
	}
	
	@GetMapping("/time")
	public String time(){
		logger.error(LocalTime.now().toString());
		logger.debug("UserService Test");
		return LocalTime.now().toString();
	}
	
	@GetMapping("/header")
	public String headerByAnnotation(@RequestHeader(name="User-agent", required = false) String userAgent,  @RequestHeader(name="test", required = false) String test  ){
		return new StringBuilder("User-agent: ").append(userAgent).append("\nTest: ").append(test).toString();
	}

}
