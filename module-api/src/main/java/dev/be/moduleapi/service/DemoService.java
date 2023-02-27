package dev.be.moduleapi.service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

	@Value("${profile-name}")
	private String name;

	private final CommonDemoService commonDemoService;

	public String save() {
		System.out.println("name: " + name);
		return "save";
	}

	public String find() {
		return "find";
	}

	public String exception() {
		if (true) {
			throw new CustomException(CodeEnum.UNKNOWN_ERROR);
		}
		return "exception";
	}
}
