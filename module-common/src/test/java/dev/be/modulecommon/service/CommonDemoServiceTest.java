package dev.be.modulecommon.service;

import static org.junit.jupiter.api.Assertions.*;

import dev.be.modulecommon.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DisplayName("테스트")
@DataJpaTest
class CommonDemoServiceTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void test() {

	}
}