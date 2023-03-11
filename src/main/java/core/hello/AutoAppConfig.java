package core.hello;

import core.hello.member.MemberRepository;
import core.hello.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // ComponentScan 을 붙히면
        // Component 애너테이션이 붙은 클래스를 스프링 빈으로 자동 등록한다.
        // Autowired 애너테이션을 붙이면 자동으로 DI를 해준다
        // 같은 타입의 구현체를 찾아서 의존관계를 맺어준다
//        basePackages = "core.hello.member", // basePackages 를 구성정보에 추가하면 원하는 package 만 탐색하여 스캔한다.
//        basePackageClasses = AutoAppConfig.class, // 지정한 클래스의 패키지를 탐색한다.
        // 지정하지 않으면 ComponentScan 이 붙은 Class 패키지로 부터 시작해서 하위 패키지를 전부 스캔한다.
        // (지정하지 않는 것이 관례이기 때문에 주로 이 방법을 사용한다.

        // ComponentScan 은 다음 애너테이션도 추가 대상에 포함된다
        // @Component // 컴포넌트에 사용
        // @Controller // 스프링 MVC 에 사용
        // @Service // 스프링 비즈니스에 사용
        // @Repository // 스프링 데이터 접근 계층에서 사용
        // @Configuration // 스프링 설정정보에 사용


        // Filter
        // include = ComponentScan 대상에 포함
        // exclude = ComponentScan 대상에서 제외
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 걸러낼 요소를 지정하는 방법.
)

// 수동등록 빈과 자동등록 빈 중에서 이름에 중복이 발생하는경우
// 수동등록 빈의 우선권을 같는다.
public class AutoAppConfig {
//
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
