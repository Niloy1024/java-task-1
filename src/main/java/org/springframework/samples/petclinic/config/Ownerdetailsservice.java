package org.springframework.samples.petclinic.config;

import lombok.RequiredArgsConstructor;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Ownerdetailsservice implements UserDetailsService {
    private final OwnerRepository ownerRepository;
    @Override
    public Owner loadUserByUsername(String username) throws UsernameNotFoundException {
        Owner owner = ownerRepository.findByfirstName(username);
        if(owner == null)throw new  UsernameNotFoundException("jkjdsc");
        return owner ;
    }
}
