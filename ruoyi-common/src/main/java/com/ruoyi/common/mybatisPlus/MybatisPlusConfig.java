package com.ruoyi.common.mybatisPlus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xw
 * @version 1.0
 * @date 2021/10/22 16:47
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MySqlInjector sqlInjector() {
        return new MySqlInjector();
    }

}
