package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Finalidade;
import br.com.sidlar.rotstock.domain.StatusItemEstoqueRotativo;
import br.com.sidlar.rotstock.domain.equipamento.EquipamentoRepository;
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

    @Autowired
    EquipamentoFormService equipamentoFormService;

    @RequestMapping(value = "/EntradaEquipamento", method = RequestMethod.GET)
    public String goHome(EquipamentoForm equipamentoForm,ModelMap modelMap) {
        return "busca-equipamento-modal";
    }

    @RequestMapping(value = "/EntradaEquipamentoPopulada",method = RequestMethod.GET)
    public String mostraTelaPopulada(EquipamentoForm equipamentoForm,ModelMap modelMap) {
        modelMap.addAttribute("equipamentoForm", equipamentoFormService.buscaEquipamentoPorId(equipamentoForm.getId()));
        return "entrada-equipamento";
    }

    @RequestMapping(value = "/BuscaEquipamentoSerial",method = RequestMethod.GET)
    public String buscaComResultado(EquipamentoForm equipamentoForm,ModelMap modelMap) {
        modelMap.addAttribute("equipamentoForm", equipamentoFormService.buscaEquipamentoPorSerial(equipamentoForm.getSerial()));
        return "busca-equipamento-modal";
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
