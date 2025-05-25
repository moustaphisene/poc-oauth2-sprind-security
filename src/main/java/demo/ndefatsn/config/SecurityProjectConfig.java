package demo.ndefatsn.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityProjectConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/secure").authenticated())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration github = githubClientRegistration();
        ClientRegistration facebook = facebookClientRegistration();
        return new InMemoryClientRegistrationRepository(github, facebook);
    }

    private ClientRegistration githubClientRegistration() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("Ov23liGyH72L5gdZzAI0")
                .clientSecret("24197458ade73e41bdb53e1f808b7f93e36c8b83").build();
    }

    private ClientRegistration facebookClientRegistration() {
        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook").clientId("")
                .clientSecret("").build();
    }

}