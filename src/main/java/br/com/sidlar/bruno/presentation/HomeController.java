package br.com.sidlar.bruno.presentation;

import br.com.sidlar.bruno.domain.equipamento.TipoConexao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String goHome() {
        //TipoConexao.values();


        return "index";
    }

}
