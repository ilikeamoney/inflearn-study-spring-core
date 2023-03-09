package core.hello.xml;

import core.hello.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XMLAppContext {

    @Test
    void xmlAppContext() {
        ApplicationContext gc = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = gc.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
