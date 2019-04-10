package cn.sunyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: hrqx
 * @Date: 2019/4/8 9:30
 */
///TODO oauth2一次认证半小时，token过期怎么处理？自定义异常？token注销？
@SpringBootApplication
public class OauthResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthResourceApplication.class, args);
    }
}
