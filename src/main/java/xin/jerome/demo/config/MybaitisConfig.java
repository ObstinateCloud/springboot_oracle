package xin.jerome.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: MybaitisConfig
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2021/7/16 10:18
 */

@Configuration
@MapperScan("xin.jerome.demo.mapper")
public class MybaitisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
