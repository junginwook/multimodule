package dev.be.modulecommon.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class MemberRepositoryTest {
	@Autowired
	private final MemberRepository memberRepository;

	public MemberRepositoryTest(
			@Autowired MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Test
	void testQQQQ() {
		System.out.println("size: " + memberRepository.findAll());
	}
}