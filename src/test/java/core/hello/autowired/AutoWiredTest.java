package core.hello.autowired;

import core.hello.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    static class TestBean {

        // required = false 자동주입 대상이 없으면 수정자 메서드가 호출이 안된다.
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member1 = " + member);
        }

        // 파리미터로 @Nullable 애노테이션을 넣으면 null 을 호출
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member2 = " + member);
        }

        // 자동 주입할 대상이 없으면 Optional.empty 가 호출 된다.
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("member3 = " + member);
        }

    }
}
