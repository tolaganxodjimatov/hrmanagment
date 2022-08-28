package uz.teasy.hrmanagment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.teasy.hrmanagment.entity.UserEmployee;
import uz.teasy.hrmanagment.repository.UserEmployeeRepository;

import java.util.Optional;
import java.util.UUID;


public class KimYozganBilish implements AuditorAware<UUID> {
    @Autowired
    UserEmployeeRepository userEmployeeRepository;

    @Override
    public Optional<UUID> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null
            && authentication.isAuthenticated()
                && !authentication.getPrincipal().equals("anonymousUser")){
            UserEmployee user = (UserEmployee) authentication.getPrincipal();
            return  Optional.of(user.getId());
        }
        return Optional.empty();
    }
}
