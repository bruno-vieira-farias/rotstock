package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
class EquipamentoFormService {
    @Autowired
    EquipamentoService equipamentoService;

    public void persisteEquipamento(EquipamentoForm equipamentoForm) {
        equipamentoService.persisteEquipamento(convertToEquipamentoModel(equipamentoForm));
    }

    public void alteraEquipamento(EquipamentoForm equipamentoForm) {
        equipamentoService.alteraEquipamento(convertToEquipamentoModel(equipamentoForm));
    }

    public EquipamentoForm buscaEquipamentoPorId(int idEquipamento) {
        return convertToEquipamentoForm(equipamentoService.buscaPorId(idEquipamento));
    }

    public EquipamentoForm buscaEquipamentoPorSerial(String serial) {
        return convertToEquipamentoForm(equipamentoService.buscaPorSerial(serial));
    }

    public List<EquipamentoForm> buscaPorLocalAndTipoEquipamento(int idLocal,TipoEquipamento tipoEquipamento) {
        List<EquipamentoModel> listaEquipamentoModel = equipamentoService.buscaPorLocalAndTipoEquipamento(idLocal,tipoEquipamento);
        return convertToListOfEquipamentoForm(listaEquipamentoModel);
    }

    public List<EquipamentoForm> buscaPorTipoEquipamento(TipoEquipamento tipoEquipamento) {
        List<EquipamentoModel> listaEquipamentoModel = equipamentoService.buscaPorTipoEquipamento(tipoEquipamento);
        return convertToListOfEquipamentoForm(listaEquipamentoModel);
    }

    public List<EquipamentoForm> buscaPorLocal(int idLocal) {
        List<EquipamentoModel> listaEquipamentoModel = equipamentoService.buscaPorLocal(idLocal);
        return convertToListOfEquipamentoForm(listaEquipamentoModel);
    }

    public List<EquipamentoForm> buscaTodosEquipamentos() {
        List<EquipamentoModel> listaEquipamentoModel = equipamentoService.buscaTodosEquipamentos();
        return convertToListOfEquipamentoForm(listaEquipamentoModel);
    }

    private EquipamentoModel convertToEquipamentoModel(EquipamentoForm equipamentoForm) {
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

    private EquipamentoForm convertToEquipamentoForm(EquipamentoModel equipamentoModel) {
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

    private List<EquipamentoForm> convertToListOfEquipamentoForm(List<EquipamentoModel> listaEquipamentoModel) {
        ArrayList<EquipamentoForm> listaEquipamanentoForm = new ArrayList<>();

        for (EquipamentoModel equipamentoModel : listaEquipamentoModel) {
            listaEquipamanentoForm.add(convertToEquipamentoForm(equipamentoModel));
        }

        return listaEquipamanentoForm;
    }

}