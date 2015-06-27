package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/RemoveEquipamento")
public class RemoveEquipamentoController {
    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    BuscaPorEquipamentoForm buscaPorEquipamentoForm;

    @Autowired
    LocalRepository localRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String goHome(@RequestParam("btn-id-equipamento") Integer idEquipamento,EquipamentoForm equipamentoForm,RedirectAttributes modelMap) {
        equipamentoRepository.removeEquipamento(idEquipamento);
        modelMap.addFlashAttribute("equipamentoForm",equipamentoForm);

        return "redirect:/ConsultaEquipamento";
    }
}
