package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/CadastroEquipamento")
public class CadastroEquipamentoController {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private ConvertToEquipamento conversor;

    @RequestMapping(method = RequestMethod.GET)
    public String goHome(EquipamentoForm equipamentoForm ) {
        return "cadastro";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String cadastra(@Valid EquipamentoForm equipamentoForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cadastro";
        }
        equipamentoRepository.gravaEquipamento(conversor.getEquipamento(equipamentoForm));
        return "redirect:/CadastroEquipamento";
    }

    @ModelAttribute("proprietarios")
    public Proprietario[] getProprietarios() {
        return Proprietario.values();
    }
    @ModelAttribute("tiposImpressora")
    public TipoImpressora[] getTipoImpressora() {
        return TipoImpressora.values();
    }
    @ModelAttribute("polegadas")
    public Polegadas[] getPolegadas() {
        return Polegadas.values();
    }
    @ModelAttribute("tiposConexao")
    public TipoConexao[] getTipoConexao() {
        return TipoConexao.values();
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

