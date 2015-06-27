package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/ConsultaEquipamento")
public class ConsultaEquipamentoController {

    @Autowired
    LocalRepository localRepository;

    @Autowired
    BuscaPorEquipamentoForm buscaPorEquipamentoForm;

    @RequestMapping(method = RequestMethod.GET)
    public String consultaGet(EquipamentoForm equipamentoForm,ModelMap modelMap) {
        boolean realizaBusca = equipamentoForm.getSerial() != null;

        if (realizaBusca) {
            modelMap.addAttribute("equipamentosForm",buscaPorEquipamentoForm.getEquipamentos(equipamentoForm));
        }
        return "consulta";
    }

    @ModelAttribute("locais")
    public List<Local> getLocais() {
        return localRepository.buscaTodosLocais();
    }
    @ModelAttribute("tiposEquipamento")
    public TipoEquipamento[] getTipoEquipamento() {
        return TipoEquipamento.values();
    }
}
