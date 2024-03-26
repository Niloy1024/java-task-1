package org.niloy.samples.config;

import lombok.RequiredArgsConstructor;
import org.niloy.samples.Entities.Vet;
import org.niloy.samples.vet.VetRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Vetdetailservice implements UserDetailsService {
    private final VetRepository vetRepository;
    @Override
    public Vet  loadUserByUsername(String username) throws UsernameNotFoundException {
        Vet vet = vetRepository.findByfirstName(username);
        if(vet == null)throw new  UsernameNotFoundException("jkjdsc");
        return vet ;
    }
}
