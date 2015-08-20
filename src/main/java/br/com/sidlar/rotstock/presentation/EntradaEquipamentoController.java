package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Finalidade;
import br.com.sidlar.rotstock.domain.StatusItemEstoqueRotativo;
import br.com.sidlar.rotstock.domain.equipamento.Fabricante;
import br.com.sidlar.rotstock.domain.equipamento.Proprietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntradaEquipamentoController {

    @Autowired
    SeletorBusca seletorBusca;

    @RequestMapping(value = "/EntradaEquipamento", method = RequestMethod.GET)
    public String goHome(EquipamentoForm equipamentoForm,ModelMap modelMap) {
        EquipamentoForm e = new EquipamentoForm();
        e.setSerial("123456");
        e.setFabricante(Fabricante.AOC);
        e.setModelo("Humm");
        e.setTipoEquipamento(TipoEquipamento.IMPRESSORA);
        modelMap.addAttribute("equipamentosForm", e);


        return "busca-serial";
    }

    @RequestMapping(value = "/BuscaSerial",method = RequestMethod.GET)
    public String buscaComResultado(EquipamentoForm equipamentoForm,ModelMap modelMap) {
//        modelMap.addAttribute("equipamentosForm", seletorBusca.buscaEquipamento(equipamentoForm));



        return "busca-serial";
    }


    @ModelAttribute("statusItemRotativo")
    public StatusItemEstoqueRotativo[] getStatusItemRotativo() {
        return StatusItemEstoqueRotativo.values();
    }
    @ModelAttribute("finalidades")
    public Finalidade[] getFinalidade() {
        return Finalidade.values();
    }
}
