package com.pyt.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/sample")
public class SampleResource {

	@GetMapping
	public String sampleText() {
		return "Hi KAvya";
	}
}
