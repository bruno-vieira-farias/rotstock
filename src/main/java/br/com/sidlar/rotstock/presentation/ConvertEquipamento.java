package br.com.sidlar.rotstock.presentation;


import br.com.sidlar.rotstock.domain.equipamento.EquipamentoModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class ConvertEquipamento {

    protected EquipamentoModel toEquipamentoModel(EquipamentoForm equipamentoForm) {
        return new EquipamentoModel(
                equipamentoForm.getId(),
                equipamentoForm.getSerial(),
                equipamentoForm.getFabricante(),
                equipamentoForm.getModelo(),
                equipamentoForm.getProprietario(),
                equipamentoForm.getIdLocal(),
                equipamentoForm.getLocal(),
                equipamentoForm.getTipoEquipamento(),
                equipamentoForm.getProcessador(),
                equipamentoForm.getMemoria(),
                equipamentoForm.getHd(),
                equipamentoForm.getColorida(),
                equipamentoForm.getTipoImpressora(),
                equipamentoForm.getPolegadas(),
                equipamentoForm.getTipoConexao(),
                equipamentoForm.getSemFio(),
                equipamentoForm.getIp()
        );
    }

    protected EquipamentoForm toEquipamentoForm(EquipamentoModel equipamentoModel) {
        return new EquipamentoForm(
                equipamentoModel.getId(),
                equipamentoModel.getSerial(),
                equipamentoModel.getFabricante(),
                equipamentoModel.getModelo(),
                equipamentoModel.getProprietario(),
                equipamentoModel.getIdLocal(),
                equipamentoModel.getLocal(),
                equipamentoModel.getTipoEquipamento(),
                equipamentoModel.getProcessador(),
                equipamentoModel.getMemoria(),
                equipamentoModel.getHd(),
                equipamentoModel.getColorida(),
                equipamentoModel.getTipoImpressora(),
                equipamentoModel.getPolegadas(),
                equipamentoModel.getTipoConexao(),
                equipamentoModel.getSemFio(),
                equipamentoModel.getIp(),
                equipamentoModel.getInformacoesEspecificas()
        );
    }

    protected List<EquipamentoForm> toListOfEquipamentoForm(List<EquipamentoModel> listaEquipamentoModel) {
        ArrayList<EquipamentoForm> listaEquipamanentoForm = new ArrayList<>();

        for (EquipamentoModel equipamentoModel : listaEquipamentoModel) {
            listaEquipamanentoForm.add(toEquipamentoForm(equipamentoModel));
        }
        return listaEquipamanentoForm;
    }
}
