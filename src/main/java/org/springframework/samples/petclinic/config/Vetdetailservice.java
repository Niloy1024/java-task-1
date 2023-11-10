package org.springframework.samples.petclinic.config;

import lombok.RequiredArgsConstructor;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.security.core.userdetails.UserDetails;
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
