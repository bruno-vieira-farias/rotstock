package br.com.sidlar.rotstock.presentation.servicos;

import br.com.sidlar.rotstock.presentation.formularios.EquipamentoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeletorBusca {
    @Autowired
    private EquipamentoFormService equipamentoFormService;

    public List<EquipamentoForm> buscaEquipamento(EquipamentoForm equipamentoForm){
        boolean buscaComSerial = !equipamentoForm.getEquipamentoEspecificacao().getSerial().equalsIgnoreCase("");
        boolean buscaComLocal = equipamentoForm.getEquipamentoEspecificacao().getIdLocal() != null;
        boolean buscaComTipoEquipamento = equipamentoForm.getEquipamentoEspecificacao().getTipoEquipamento() != null;

        if(buscaComSerial){
            EquipamentoForm equipamentoFormPosBusca = equipamentoFormService.buscaEquipamentoPorSerial(equipamentoForm.getEquipamentoEspecificacao().getSerial());
            return addEquipamentoFormList(equipamentoFormPosBusca);
        }else if(buscaComLocal & buscaComTipoEquipamento){
            return equipamentoFormService.buscaPorLocalAndTipoEquipamento(equipamentoForm.getEquipamentoEspecificacao().getIdLocal(),equipamentoForm.getEquipamentoEspecificacao().getTipoEquipamento());
        }else if (buscaComLocal) {
            return equipamentoFormService.buscaPorLocal(equipamentoForm.getEquipamentoEspecificacao().getIdLocal());
        }else if (buscaComTipoEquipamento) {
           return equipamentoFormService.buscaPorTipoEquipamento(equipamentoForm.getEquipamentoEspecificacao().getTipoEquipamento());
        }else{
            return equipamentoFormService.buscaTodosEquipamentos();
        }
    }
    private List<EquipamentoForm> addEquipamentoFormList (EquipamentoForm equipamentoForm){
        ArrayList<EquipamentoForm> listaEquipamentoForm = new ArrayList<>();
        if (equipamentoForm != null) {
            listaEquipamentoForm.add(equipamentoForm);
        }
        return listaEquipamentoForm;
    }
}