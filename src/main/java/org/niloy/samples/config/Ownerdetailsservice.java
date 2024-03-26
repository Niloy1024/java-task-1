package org.niloy.samples.config;

import lombok.RequiredArgsConstructor;
import org.niloy.samples.Entities.Owner;
import org.niloy.samples.owner.OwnerRepository;
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
