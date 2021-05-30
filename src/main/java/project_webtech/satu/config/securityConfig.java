package project_webtech.satu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //only slash as homepage
                .antMatchers(
                        HttpMethod.GET,
                        endpoints.SLASH_INDEX
                ).permitAll()
                //static resources
                .antMatchers(
                        "/css/**",
                        "/images/**"
                        //"/js/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl(endpoints.SLASH_INDEX)
                .and()
                .oauth2Client()
                .and()
                .oauth2Login();
    }
}
