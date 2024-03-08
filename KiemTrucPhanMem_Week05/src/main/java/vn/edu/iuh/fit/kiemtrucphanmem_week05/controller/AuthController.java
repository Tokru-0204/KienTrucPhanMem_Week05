package vn.edu.iuh.fit.kiemtrucphanmem_week05.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.dto.AuthResponse;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.dto.LoginRequest;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.dto.SignupRequest;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.models.Security_Guard;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.services.SecurityGuardService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityGuardService securityGuardService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Security_Guard securityGuard = securityGuardService.getSecurityGuardByUsername(loginRequest.getUsername());
        String jwt = securityGuardService.generateToken(securityGuard);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest signupRequest) {
        if (securityGuardService.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new AuthResponse("Username is already taken"));
        }

        Security_Guard securityGuard = new Security_Guard();
        securityGuardService.setUsername(securityGuard, signupRequest.getUsername());
        securityGuard.setPassWord(passwordEncoder.encode(signupRequest.getPassword()));
        securityGuard.setFullName(signupRequest.getFullName());
        securityGuard.setAge(signupRequest.getAge());
        securityGuard.setAddress(signupRequest.getAddress());
        securityGuard.setSalary(signupRequest.getSalary());

        securityGuardService.saveSecurityGuard(securityGuard);

        String jwt = securityGuardService.generateToken(securityGuard);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
