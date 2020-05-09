package springannotation;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "springannotation")
public class BeanConfig {


//    @Bean
//    public Person person() {
//        return new Person();
//    }
}
