package vn.edu.iuh.fit.kiemtrucphanmem_week05.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.config.JwtTokenProvider;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.models.Security_Guard;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.repository.SecurityGuardRepository;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.services.SecurityGuardService;

import java.util.List;

@Service
public class SecurityGuardServiceImpl implements SecurityGuardService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private SecurityGuardRepository securityGuardRepository;

    @Override
    public String generateToken(Security_Guard securityGuard) {
        return jwtTokenProvider.generateToken(securityGuard);
    }
    @Override
    public List<Security_Guard> getAllSecurityGuards() {
        return securityGuardRepository.findAll();
    }

    @Override
    public void saveSecurityGuard(Security_Guard securityGuard) {
        securityGuardRepository.save(securityGuard);
    }

    @Override
    public Security_Guard getSecurityGuardById(Long id) {
        return securityGuardRepository.findById(id).orElse(null);
    }

    @Override
    public Security_Guard getSecurityGuardByUsername(String username) {
        return securityGuardRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return securityGuardRepository.existsByUsername(username);
    }

    @Override
    public void setUsername(Security_Guard securityGuard, String username) {
        securityGuard.setUserName(username);
    }

}
