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
public class ManterEquipamentoController {
    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private Converter converter;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new EquipamentoFormValidator());
    }

    @Autowired
    BuscaEquipamentoUtils buscaEquipamentoUtils;

    @RequestMapping(value="/CadastroEquipamento",method = RequestMethod.GET)
    public String mostraTelaCadastro(EquipamentoForm equipamentoForm, ModelMap modelMap) {
        equipamentoForm.setLabelBotao("Cadastrar");
        equipamentoForm.setLabelPrincipal("Cadastro de Equipamentos");
        return "cadastro-edicao";
    }
    @RequestMapping(value="/EditaEquipamento",method = RequestMethod.GET)
    public String mostraTelaEdicao(@RequestParam(value = "btn-edita") Integer idEquipamento,EquipamentoForm equipamentoForm, ModelMap modelMap) {
         Equipamento equipamento = equipamentoRepository.buscaPorId(idEquipamento);
         equipamentoForm = converter.convertToEquipamentoForm(equipamento);
         equipamentoForm.setLabelBotao("Alterar");
         equipamentoForm.setLabelPrincipal("Alteração de Equipamentos");

         modelMap.addAttribute("equipamentoForm",equipamentoForm);
        return "cadastro-edicao";
    }
    @RequestMapping(value = "/CadastrarEquipamento" ,method = RequestMethod.POST)
    public String cadastraEquipamento(@Valid EquipamentoForm equipamentoForm, BindingResult bindingResult, RedirectAttributes modelMap) {
        equipamentoForm.setLabelBotao("Cadastrar");
        equipamentoForm.setLabelPrincipal("Cadastro de Equipamentos");

        if (bindingResult.hasErrors()) {
            return "cadastro-edicao";
        }
        equipamentoRepository.gravaEquipamento(converter.convertToEquipamento(equipamentoForm));
        modelMap.addFlashAttribute("mensagem", "O equipamento " + equipamentoForm.getTipoEquipamento().descricao + " de serial " + equipamentoForm.getSerial() + " foi salvo com sucesso");

        return "redirect:/CadastroEquipamento";
    }
    @RequestMapping(value = "/EditarEquipamento" ,method = RequestMethod.POST)
    public String editaEquipamento(@Valid EquipamentoForm equipamentoForm, BindingResult bindingResult, RedirectAttributes modelMap) {
        if (bindingResult.hasErrors()) {
            return "cadastro-edicao";
        }
        equipamentoRepository.alteraEquipamento(converter.convertToEquipamento(equipamentoForm));
        modelMap.addFlashAttribute("mensagem", "O equipamento " + equipamentoForm.getTipoEquipamento().descricao + " de serial " + equipamentoForm.getSerial() + " foi alterado com sucesso");

        return "redirect:/CadastroEquipamento";
    }
    @RequestMapping(value = "/BuscaEquipamento",method = RequestMethod.GET)
    public String buscaVazia(EquipamentoForm equipamentoForm ,ModelMap modelMap) {
        return "busca";
    }

    @RequestMapping(value = "/BuscaEquipamentoCom",method = RequestMethod.GET)
    public String buscaComResultado(EquipamentoForm equipamentoForm,ModelMap modelMap) {
        modelMap.addAttribute("equipamentosForm", buscaEquipamentoUtils.buscaEquipamento(equipamentoForm));
        return "busca";
    }

    @RequestMapping(value ="/RemoveEquipamento" ,method = RequestMethod.POST)
    public String goHome(@RequestParam("btn-id-equipamento") Integer idEquipamento,EquipamentoForm equipamentoForm,RedirectAttributes modelMap) {
        equipamentoRepository.removeEquipamento(idEquipamento);
        modelMap.addFlashAttribute("equipamentoForm",equipamentoForm);

        return "redirect:/BuscaEquipamentoCom";
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