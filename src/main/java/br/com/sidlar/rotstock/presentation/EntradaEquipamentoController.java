package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Finalidade;
import br.com.sidlar.rotstock.domain.ItemEstoqueRotativo;
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
    EquipamentoFormService equipamentoFormService;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @RequestMapping(value = "/EntradaEquipamentoSemEquipamento", method = RequestMethod.GET)
    public String goHome(EquipamentoForm equipamentoForm,ModelMap modelMap) {
        return "busca-equipamento-modal";
    }

    //Pay Atention in this Sheat
    @RequestMapping(value = "/EntradaEquipamentoComEquipamento",method = RequestMethod.GET)
    public String mostraTelaPopulada(EquipamentoForm equipamentoForm,ModelMap modelMap,ItemEstoqueRotativoForm itemEstoqueRotativoForm) {
        equipamentoForm = equipamentoFormService.buscaEquipamentoPorId(equipamentoForm.getId());
            itemEstoqueRotativoForm.setEquipamento(equipamentoRepository.buscaPorId(equipamentoForm.getId()));
            itemEstoqueRotativoForm.setTipoEquipamento(equipamentoForm.getTipoEquipamento());
            itemEstoqueRotativoForm.setLocal(equipamentoForm.getLocal());
        return "entrada-equipamento";
    }

    @RequestMapping(value = "/DarEntradaEquipamento",method = RequestMethod.POST)
    public String darEntradaEquipamento(ItemEstoqueRotativoForm itemEstoqueRotativoForm) {


        //TODO Dar entrada no equipamanento

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
