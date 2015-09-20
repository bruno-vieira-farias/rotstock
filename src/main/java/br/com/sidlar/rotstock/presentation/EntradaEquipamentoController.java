package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Finalidade;
import br.com.sidlar.rotstock.domain.StatusItemEstoqueRotativo;
import br.com.sidlar.rotstock.domain.equipamento.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EntradaEquipamentoController {
    @Autowired
    private EquipamentoFormService equipamentoFormService;

    @Autowired
    private EstoqueRotativoService estoqueRotativoService;

    @RequestMapping(value = "/EntradaEquipamentoSemEquipamento", method = RequestMethod.GET)
    public String goHome(ItemEstoqueRotativoForm itemEstoqueRotativoForm) {
        return "busca-equipamento-modal";
    }

    @RequestMapping(value = "/EntradaEquipamentoComEquipamento",method = RequestMethod.GET)
    public String mostraTelaPopulEquipamentoForm(@RequestParam("id-equipamento") int idEquipamento , ItemEstoqueRotativoForm itemEstoqueRotativoForm) {
            itemEstoqueRotativoForm.setEquipamentoForm(equipamentoFormService.buscaEquipamentoPorId(idEquipamento));
        return "entrada-equipamento";
    }

    @RequestMapping(value = "/DarEntradaEquipamento",method = RequestMethod.POST)
    public String darEntradaEquipamento(ItemEstoqueRotativoForm itemEstoqueRotativoForm){
            itemEstoqueRotativoForm.darEntrada();
        return "entrada-equipamento";
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
