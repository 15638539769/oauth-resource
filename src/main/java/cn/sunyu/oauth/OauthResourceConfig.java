package cn.sunyu.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @Author: hrqx
 * @Date: 2019/4/8 9:34
 */
@Configuration
@EnableResourceServer
public class OauthResourceConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public RemoteTokenServices getRemoteTokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
        ///TODO 资源服务器并未认证客户端信息,此处clientId和clientSecret对应的客户端和访问资源的客户端没有对应关系
        remoteTokenServices.setClientId("oauth_client");
        remoteTokenServices.setClientSecret("oauth_client_secret");
        return remoteTokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(getRemoteTokenServices());
        resources.resourceId("my_resource_id");
    }

    ///TODO oauth2管理特定接口其他的交给security管理
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/read_user_info").authorizeRequests().anyRequest().authenticated();
    }

}
