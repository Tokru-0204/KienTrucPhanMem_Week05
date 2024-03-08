package vn.edu.iuh.fit.kiemtrucphanmem_week05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.services.SecurityGuardService;

@Controller
public class WebController {
    @Autowired
    private SecurityGuardService securityGuardService;

    @GetMapping("/security-guards")
    public String showSecurityGuards(Model model) {
        model.addAttribute("securityGuards", securityGuardService.getAllSecurityGuards());
        return "security-guards";
    }
}
