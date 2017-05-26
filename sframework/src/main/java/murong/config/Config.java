package murong.config;

import murong.aop.Aop;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by murong on 2017/4/28.
 */
@Configuration()
@EnableAspectJAutoProxy
@ComponentScan("murong.*")//扫描murong下的bean
public class Config {

    @Bean
    @Profile("dev")//开发环境时用
    @Conditional(ExampleExistsCondition.class)//满足条件时用
    public String example(){
        return "example";
    }

    @Bean
    public Aop aop(){
        return new Aop();
    }

}

class ExampleExistsCondition implements Condition{

    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //有问题，找不到！！
        Environment env = conditionContext.getEnvironment();
        return env.containsProperty("example");
    }
}
