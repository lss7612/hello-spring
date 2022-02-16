package hello.hello.spring;

import hello.hello.spring.aop.TimeTraceAop;
import hello.hello.spring.repository.JdbcMemberRepository;
import hello.hello.spring.repository.JpaMemberRepository;
import hello.hello.spring.repository.MemberRepository;
import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    //자바 코드로 직접 스프링 빈 등록하기
    //XML 대신 사용할 수 있다.

    //DI는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있다.
    //결론적으로 생성자 주입으로 DI를 하는것이 좋다.

    //config 파일로 스프링 빈으로 등록하는 경우는
    // 상황에 따라 구현클래스를 변경해야 하는 경우이다.

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    
//    //위 코드는 jpa에서는 Entity manager로 받아야함
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
        //생성자 주입의 예
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //생성자 주입의 예
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }
    
    //필드 주입의 예
    //단점: 중간에 인스턴스를 바꿔주거나 하는것이 불가능하다.
    //@Autowired MemberService memberService;


    //세터 주입의 예
    //단점: 내부 필드를 public으로 바꿔줘야고, 중간에 동적으로 바꾸면 문제가 있을 수 있다.
//    MemberService memberService;
//    @Autowired
//    public setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }




}


