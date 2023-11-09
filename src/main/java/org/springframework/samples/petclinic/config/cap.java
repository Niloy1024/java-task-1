//package org.springframework.samples.petclinic.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.samples.petclinic.vet.VetRepository;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@RequiredArgsConstructor
//public class cap implements AuthenticationProvider {
//    private final VetRepository vetRepository;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false  ;
//    }
//}
