package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class EquipamentoFormService {
    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private ConvertEquipamento convertEquipamento;

    public void persisteEquipamento(EquipamentoForm equipamentoForm) {
        equipamentoService.persisteEquipamento(convertEquipamento.toEquipamentoModel(equipamentoForm));
    }

    public void alteraEquipamento(EquipamentoForm equipamentoForm) {
        equipamentoService.alteraEquipamento(convertEquipamento.toEquipamentoModel(equipamentoForm));
    }

    public EquipamentoForm buscaEquipamentoPorId(int idEquipamento) {
        return convertEquipamento.toEquipamentoForm(equipamentoService.buscaPorId(idEquipamento));
    }

    public EquipamentoForm buscaEquipamentoPorSerial(String serial) {
       EquipamentoModel equipamentoModel = equipamentoService.buscaPorSerial(serial);
        if (equipamentoModel != null) {
            return convertEquipamento.toEquipamentoForm(equipamentoModel);
        }
        return null;
    }

    public List<EquipamentoForm> buscaPorLocalAndTipoEquipamento(int idLocal,TipoEquipamento tipoEquipamento) {
        List<EquipamentoModel> listaEquipamentoModel = equipamentoService.buscaPorLocalAndTipoEquipamento(idLocal, tipoEquipamento);
        return convertEquipamento.toListOfEquipamentoForm(listaEquipamentoModel);
    }

    public List<EquipamentoForm> buscaPorTipoEquipamento(TipoEquipamento tipoEquipamento) {
        List<EquipamentoModel> listaEquipamentoModel = equipamentoService.buscaPorTipoEquipamento(tipoEquipamento);
        return convertEquipamento.toListOfEquipamentoForm(listaEquipamentoModel);
    }

    public List<EquipamentoForm> buscaPorLocal(int idLocal) {
        List<EquipamentoModel> listaEquipamentoModel = equipamentoService.buscaPorLocal(idLocal);
        return convertEquipamento.toListOfEquipamentoForm(listaEquipamentoModel);
    }

    public List<EquipamentoForm> buscaTodosEquipamentos() {
        List<EquipamentoModel> listaEquipamentoModel = equipamentoService.buscaTodosEquipamentos();
        return convertEquipamento.toListOfEquipamentoForm(listaEquipamentoModel);
    }
}