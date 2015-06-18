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
    EquipamentoRepository equipamentoRepository;

    @Autowired
    EquipamentoToEquipamentoFormConverter convertEquipamentoForm;

    @RequestMapping(method = RequestMethod.GET)
    public String consultaGet(EquipamentoForm equipamentoForm) {

        return "consulta";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String consultaPost(ModelMap modelMap,EquipamentoForm equipamentoForm) {
        boolean consultaComSerial = (equipamentoForm.getSerial().equalsIgnoreCase(""))?false:true;
        boolean consultaComLocal = (equipamentoForm.getIdLocal() == null)?false:true;
        boolean consultaComTipoEquipamento = (equipamentoForm.getTipoEquipamento() == null)?false:true;

        if(consultaComSerial){
            modelMap.addAttribute("equipamentosForm",convertEquipamentoForm.getEquipamentoForm(equipamentoRepository.buscaPorSerial(equipamentoForm.getSerial())));
            return "consulta";
        }
        if(consultaComLocal & consultaComTipoEquipamento){
            modelMap.addAttribute("equipamentosForm",convertEquipamentoForm.getEquipamentoForm(equipamentoRepository.buscaPorTipoEquipamentoLocal(
                    classPorTipoEquipamento(equipamentoForm.getTipoEquipamento()),equipamentoForm.getIdLocal()
            )));
            return "consulta";
        }
        if (consultaComLocal) {
            modelMap.addAttribute("equipamentosForm",convertEquipamentoForm.getEquipamentoForm(equipamentoRepository.buscaPorLocal(equipamentoForm.getIdLocal())));
            return "consulta";
        }
        if (consultaComTipoEquipamento) {
            modelMap.addAttribute(
                    "equipamentosForm",convertEquipamentoForm.getEquipamentoForm(
                        equipamentoRepository.buscaPorTipoEquipamento(
                                classPorTipoEquipamento(
                                                    equipamentoForm.getTipoEquipamento()))));
            return "consulta";
        }
        modelMap.addAttribute("equipamentosForm",convertEquipamentoForm.getEquipamentoForm(equipamentoRepository.buscaTodos()));
        return "consulta";
    }
    private Class classPorTipoEquipamento(TipoEquipamento tipoEquipamento) {
        switch (tipoEquipamento){
            case COMPUTADOR:
                return Computador.class;
            case MONITOR:
                return Monitor.class;
            case IMPRESSORA:
                return Impressora.class;
            case LEITOR_CHEQUE:
                return LeitorCheque.class;
            case TECLADO:
                return Teclado.class;
            case MOUSE:
                return  Mouse.class;
            case TELEFONE:
                return Telefone.class;
            default:
                throw new IllegalArgumentException("Não é possivel buscar o equipamento com o identificador " + tipoEquipamento);
        }
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
