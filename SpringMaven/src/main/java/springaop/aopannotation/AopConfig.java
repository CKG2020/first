package springaop.aopannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "springaop.aopannotation")
@EnableAspectJAutoProxy
public class AopConfig {
}
