package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private EquipamentoFormToEquipamentoConverter conversorEquipamentoForm;

    @Autowired
    private EquipamentoToEquipamentoFormConverter conversorEquipamento;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new EquipamentoFormValidator());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String goHome(@RequestParam(value = "btn-edita", required = false) Integer idEquipamento,EquipamentoForm equipamentoForm, ModelMap modelMap) {
        if (idEquipamento != null) {
           Equipamento equipamento = equipamentoRepository.buscaPorId(idEquipamento);
            equipamentoForm = conversorEquipamento.getEquipamentoForm(equipamento);

            modelMap.addAttribute("equipamentoForm",equipamentoForm);
        }
        return "cadastro";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String cadastra(@Valid EquipamentoForm equipamentoForm, BindingResult bindingResult, RedirectAttributes modelMap) {
        if (bindingResult.hasErrors()) {
            return "cadastro";
        }
        if (equipamentoForm.getId() == null) {
            equipamentoRepository.gravaEquipamento(conversorEquipamentoForm.getEquipamento(equipamentoForm));
            modelMap.addFlashAttribute("mensagem", "O equipamento " + equipamentoForm.getTipoEquipamento().descricao + " de serial " + equipamentoForm.getSerial() + " foi salvo com sucesso");
        } else {
            equipamentoRepository.alteraEquipamento(conversorEquipamentoForm.getEquipamento(equipamentoForm));
            modelMap.addFlashAttribute("mensagem", "O equipamento " + equipamentoForm.getTipoEquipamento().descricao + " de serial " + equipamentoForm.getSerial() + " foi alterado com sucesso");
        }
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
    @ModelAttribute("fabricantes")
    public Fabricante[] getFabricantes() {
        return Fabricante.values();
    }
    @ModelAttribute("processadores")
    public Processador[] getProcessadores() {
        return Processador.values();
    }
    @ModelAttribute("memorias")
    public Memoria[] getMemorias() {
        return Memoria.values();
    }
    @ModelAttribute("hds")
    public Hd[] getHds() {
        return Hd.values();
    }
}
