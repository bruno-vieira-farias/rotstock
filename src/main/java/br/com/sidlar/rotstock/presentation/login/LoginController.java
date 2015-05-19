package br.com.sidlar.rotstock.presentation.login;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    @Transactional
    public ModelAndView goHome(@RequestParam Optional<String> error) {
        return new ModelAndView("login/login-form", "error", error);
    }
}
