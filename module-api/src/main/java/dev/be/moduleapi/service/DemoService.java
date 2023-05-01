package dev.be.moduleapi.service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repository.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

	@Value("${profile-name}")
	private String name;

	private final CommonDemoService commonDemoService;

	private final MemberRepository memberRepository;

	public String save() {
		Member member = Member.builder()
				.name("inwook")
				.build();

		memberRepository.save(member);
		return "save";
	}

	public String find() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		Member member = memberOptional.orElseThrow(
				() -> new CustomException(CodeEnum.UNKNOWN_ERROR)
		);

		return member.getName();
	}

	public String exception() {
		if (true) {
			throw new CustomException(CodeEnum.UNKNOWN_ERROR);
		}
		return "exception";
	}
}
