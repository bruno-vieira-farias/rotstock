package br.com.sidlar.rotstock.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuscaEquipamentoUtils{
    @Autowired
    private EquipamentoFormService equipamentoFormService;

    public List<EquipamentoForm> buscaEquipamento(EquipamentoForm equipamentoForm){
        boolean buscaComSerial = !equipamentoForm.getSerial().equalsIgnoreCase("");
        boolean buscaComLocal = equipamentoForm.getIdLocal() != null;
        boolean buscaComTipoEquipamento = equipamentoForm.getTipoEquipamento() != null;

        if(buscaComSerial){
            //if (equipamentoRepository.exists(equipamentoForm.getSerial()));
            EquipamentoForm equipamentoFormPosBusca = equipamentoFormService.buscaEquipamentoPorSerial(equipamentoForm.getSerial());
            return addEquipamentoFormList(equipamentoFormPosBusca);
        }else if(buscaComLocal & buscaComTipoEquipamento){
            return equipamentoFormService.buscaPorLocalAndTipoEquipamento(equipamentoForm.getIdLocal(),equipamentoForm.getTipoEquipamento());
        }else if (buscaComLocal) {
            return equipamentoFormService.buscaPorLocal(equipamentoForm.getIdLocal());
        }else if (buscaComTipoEquipamento) {
           return equipamentoFormService.buscaPorTipoEquipamento(equipamentoForm.getTipoEquipamento());
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