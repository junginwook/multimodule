package dev.be.moduleapi.controller;

import dev.be.moduleapi.service.DemoService;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.repository.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

	private final DemoService demoService;

	@GetMapping("/save")
	public String save() {
		return demoService.save();
	}

	@GetMapping("/find")
	public String find() {
		return demoService.find();
	}

	@GetMapping("/articles")
	public String articles() {
		return "articles";
	}

	@GetMapping("/exception")
	public String exception() {
		return demoService.exception();
	}
}
