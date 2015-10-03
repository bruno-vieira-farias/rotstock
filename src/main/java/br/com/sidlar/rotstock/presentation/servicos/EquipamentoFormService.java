package br.com.sidlar.rotstock.presentation.servicos;

import br.com.sidlar.rotstock.domain.equipamento.*;
import br.com.sidlar.rotstock.presentation.servicos.ConvertEquipamento;
import br.com.sidlar.rotstock.presentation.formularios.EquipamentoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquipamentoFormService {
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
       EquipamentoEspecificacao equipamentoEspecificacao = equipamentoService.buscaPorSerial(serial);
        if (equipamentoEspecificacao != null) {
            return convertEquipamento.toEquipamentoForm(equipamentoEspecificacao);
        }
        return null;
    }

    public List<EquipamentoForm> buscaPorLocalAndTipoEquipamento(int idLocal,TipoEquipamento tipoEquipamento) {
        List<EquipamentoEspecificacao> listaEquipamentoEspecificacao = equipamentoService.buscaPorLocalAndTipoEquipamento(idLocal, tipoEquipamento);
        return convertEquipamento.toListOfEquipamentoForm(listaEquipamentoEspecificacao);
    }

    public List<EquipamentoForm> buscaPorTipoEquipamento(TipoEquipamento tipoEquipamento) {
        List<EquipamentoEspecificacao> listaEquipamentoEspecificacao = equipamentoService.buscaPorTipoEquipamento(tipoEquipamento);
        return convertEquipamento.toListOfEquipamentoForm(listaEquipamentoEspecificacao);
    }

    public List<EquipamentoForm> buscaPorLocal(int idLocal) {
        List<EquipamentoEspecificacao> listaEquipamentoEspecificacao = equipamentoService.buscaPorLocal(idLocal);
        return convertEquipamento.toListOfEquipamentoForm(listaEquipamentoEspecificacao);
    }

    public List<EquipamentoForm> buscaTodosEquipamentos() {
        List<EquipamentoEspecificacao> listaEquipamentoEspecificacao = equipamentoService.buscaTodosEquipamentos();
        return convertEquipamento.toListOfEquipamentoForm(listaEquipamentoEspecificacao);
    }
}