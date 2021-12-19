package xian.zhongliang.dengjumin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xian.zhongliang.dengjumin.mapper")
public class DengJuMinApplication {

    public static void main(String[] args) {
        SpringApplication.run(DengJuMinApplication.class, args);
    }

}
