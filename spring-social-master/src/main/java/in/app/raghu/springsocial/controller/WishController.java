package in.app.raghu.springsocial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishController 
{
	@GetMapping("/wish")
	public String wishMsg()
	{
		return "Hello,Good Morning";
	}

}
