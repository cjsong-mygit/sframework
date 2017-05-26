package murong.config.mvc;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by murong on 2017/4/28.
 */
@Configuration
@ComponentScan(basePackages = {"murong.*"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {
}
