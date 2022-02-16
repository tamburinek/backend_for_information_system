package cz.cvut.fel.ear.instakos.config;

import cz.cvut.fel.ear.instakos.security.SecurityConstants;
import cz.cvut.fel.ear.instakos.security.jwt.AuthEntryPointJwt;
import cz.cvut.fel.ear.instakos.security.jwt.AuthTokenFilter;
import cz.cvut.fel.ear.instakos.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

// Allow methods to be secured using annotation


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


//    private static final String[] COOKIES_TO_DESTROY = {
//            SecurityConstants.SESSION_COOKIE_NAME,
//            SecurityConstants.REMEMBER_ME_COOKIE_NAME
//    };
//
//    private final AuthenticationFailureHandler authenticationFailureHandler;
//
//    private final AuthenticationSuccessHandler authenticationSuccessHandler;
//
//    private final LogoutSuccessHandler logoutSuccessHandler;
//
//    private final AuthenticationProvider authenticationProvider;
//
//    private final UserDetailsService userDetailsService;
//
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//    @Autowired
//    public SecurityConfig(AuthenticationFailureHandler authenticationFailureHandler,
//                          AuthenticationSuccessHandler authenticationSuccessHandler,
//                          LogoutSuccessHandler logoutSuccessHandler,
//                          AuthenticationProvider authenticationProvider, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.authenticationFailureHandler = authenticationFailureHandler;
//        this.authenticationSuccessHandler = authenticationSuccessHandler;
//        this.logoutSuccessHandler = logoutSuccessHandler;
//        this.authenticationProvider = authenticationProvider;
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//        auth.authenticationProvider(authenticationProvider);
//    }
//
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManager();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        CustomAuthentificationFilter customAuthentificationFilter = new CustomAuthentificationFilter(authenticationManagerBean());
////        customAuthentificationFilter.setFilterProcessesUrl("/instakos/signin");
////
////        http.csrf().disable();
////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http.authorizeRequests().anyRequest().permitAll();
////        http.addFilter(customAuthentificationFilter);
////
//////        http.authorizeRequests().anyRequest().permitAll();
//////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//////        http.addFilter(new CustomAuthentificationFilter(authenticationManagerBean()));
//////        http.csrf().disable().formLogin().successHandler(authenticationSuccessHandler).loginProcessingUrl(SecurityConstants.SECURITY_CHECK_URI)
//////                .usernameParameter(SecurityConstants.USERNAME_PARAM).passwordParameter(SecurityConstants.PASSWORD_PARAM);
//
//
//        http.authorizeRequests().anyRequest().permitAll().and()
//                .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .and().headers().frameOptions().sameOrigin()
//                .and().authenticationProvider(authenticationProvider)
//                .csrf().disable()
//                .formLogin().successHandler(authenticationSuccessHandler)
//                .failureHandler(authenticationFailureHandler)
//                .loginProcessingUrl(SecurityConstants.SECURITY_CHECK_URI)
//                .usernameParameter(SecurityConstants.USERNAME_PARAM).passwordParameter(SecurityConstants.PASSWORD_PARAM)
//                .and()
//                .logout().invalidateHttpSession(true).deleteCookies(COOKIES_TO_DESTROY)
//                .logoutUrl(SecurityConstants.LOGOUT_URI).logoutSuccessUrl("/login")
//                .and().sessionManagement().maximumSessions(1);
//    }
}
