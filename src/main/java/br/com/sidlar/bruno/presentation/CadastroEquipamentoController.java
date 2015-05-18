package br.com.sidlar.bruno.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/CadastroEquipamento")
public class CadastroEquipamentoController {

    @RequestMapping(method = RequestMethod.GET)
    public String goHome() {
        return "cadastro";
    }
}
