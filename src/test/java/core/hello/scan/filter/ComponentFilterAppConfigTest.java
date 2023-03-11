package core.hello.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.FilterType.ANNOTATION;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        assertThrows(
                NoSuchBeanDefinitionException.class, () ->
                ac.getBean("beanB", BeanB.class)
        );
    }


    // Filter Options
    // ANNOTATION : 기본값 애너테이션이을 인식해서 동작한다.
    // ASSIGNABLE_TYPE : 지정한 타입과 자식 타입을 인식해서 동작한다.
    // ASPECTJ : AspectJ 패턴을 사용
    // REGEX : 정규식 표현
    // CUSTOM : TypeFilter 라는 interface 를 구현해서 처리
    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }
}
