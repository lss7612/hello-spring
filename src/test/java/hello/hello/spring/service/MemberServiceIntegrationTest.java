package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repository.MemberRepository;
import hello.hello.spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    //테스트에서는 생성자로 인젝션하지 않는다.
    @Autowired MemberService memberService;
    @Autowired MemberRepository repository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long memberId = memberService.join(member);

        //then
        Member result = memberService.findOne(memberId).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void dupMemberTest(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");


        //when
        memberService.join(member1);

        Exception e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}