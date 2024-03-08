package vn.edu.iuh.fit.kiemtrucphanmem_week05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.models.Security_Guard;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.services.SecurityGuardService;

import java.util.List;

@RestController
@RequestMapping("/api/security-guards")
public class SecurityGuardController {
    @Autowired
    private SecurityGuardService securityGuardService;

    @GetMapping
    public ResponseEntity<List<Security_Guard>> getAllSecurityGuards() {
        List<Security_Guard> securityGuards = securityGuardService.getAllSecurityGuards();
        return new ResponseEntity<>(securityGuards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Security_Guard> getSecurityGuardById(@PathVariable Long id) {
        Security_Guard securityGuard = securityGuardService.getSecurityGuardById(id);
        if (securityGuard != null) {
            return new ResponseEntity<>(securityGuard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createSecurityGuard(@RequestBody Security_Guard securityGuard) {
        securityGuardService.saveSecurityGuard(securityGuard);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
