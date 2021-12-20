package xian.zhongliang.dengjumin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import xian.zhongliang.dengjumin.utils.WxMappingJackson2HttpMessageConverter;

@SpringBootApplication
@MapperScan("xian.zhongliang.dengjumin.mapper")
public class DengJuMinApplication {

    public static void main(String[] args) {
        SpringApplication.run(DengJuMinApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;

    }
}
