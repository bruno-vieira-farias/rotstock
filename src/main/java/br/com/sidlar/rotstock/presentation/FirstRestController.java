package br.com.sidlar.rotstock.presentation;


import br.com.sidlar.rotstock.presentation.formularios.EquipamentoForm;
import br.com.sidlar.rotstock.presentation.servicos.EquipamentoFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
    @Autowired
    private EquipamentoFormService equipamentoFormService;

    @RequestMapping(value ="/consultaSerial" ,method = RequestMethod.GET)
    public EquipamentoForm consultaSerial(@RequestParam("serial") String serial) {
        return equipamentoFormService.buscaEquipamentoPorSerial(serial);
    }
}
