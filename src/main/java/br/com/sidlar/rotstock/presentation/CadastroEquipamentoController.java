package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/CadastroEquipamento")
public class CadastroEquipamentoController {

    @Autowired
    private LocalRepository localRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String goHome(EquipamentoForm equipamentoForm, ModelMap modelMap) {
       // Equipamento e = equipamentoForm.toEquipamento();
        // equipamentoRepository.guarda(e);
        modelMap.addAttribute("proprietarios", Proprietario.values());
        modelMap.addAttribute("tiposImpressora", TipoImpressora.values());
        modelMap.addAttribute("polegadas", Polegadas.values());
        modelMap.addAttribute("tiposConexao", TipoConexao.values());
        modelMap.addAttribute("locais", localRepository.buscaTodosLocais());
        modelMap.addAttribute("tiposEquipamento",TipoEquipamento.values());

        return "cadastro";
    }
}
