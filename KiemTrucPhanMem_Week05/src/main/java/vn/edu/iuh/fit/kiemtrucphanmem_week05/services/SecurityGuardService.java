package vn.edu.iuh.fit.kiemtrucphanmem_week05.services;

import vn.edu.iuh.fit.kiemtrucphanmem_week05.models.Security_Guard;

import java.util.List;

public interface SecurityGuardService {
    String generateToken(Security_Guard securityGuard);

    List<Security_Guard> getAllSecurityGuards();

    void saveSecurityGuard(Security_Guard securityGuard);
    Security_Guard getSecurityGuardById(Long id);

    Security_Guard getSecurityGuardByUsername(String username);
    boolean existsByUsername(String username);

    void setUsername(Security_Guard securityGuard, String username);
}
