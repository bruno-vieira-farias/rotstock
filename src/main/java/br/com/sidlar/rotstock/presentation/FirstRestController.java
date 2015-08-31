package br.com.sidlar.rotstock.presentation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class FirstRestController {
    @Autowired
    EquipamentoFormService equipamentoFormService;

    @RequestMapping(value ="/consultaSerial" ,method = RequestMethod.GET)
    public EquipamentoForm consultaSerial(@RequestParam("serial") String serial) {
        return equipamentoFormService.buscaEquipamentoPorSerial(serial);
    }
}
