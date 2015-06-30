package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.Equipamento;
import br.com.sidlar.rotstock.domain.equipamento.fabrica.CaracteristicasBasicasEquipamento;
import br.com.sidlar.rotstock.domain.equipamento.fabrica.EquipamentoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class EquipamentoFormToEquipamentoConverter {
   @Autowired
    LocalRepository localRepository;


    @Autowired
    private EquipamentoFactory equipamentoFactory;

    public Equipamento getEquipamento(EquipamentoForm equipamentoForm) {
        CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento =
                new CaracteristicasBasicasEquipamento(
                        equipamentoForm.getId(),
                        equipamentoForm.getSerial(),
                        equipamentoForm.getFabricante(),
                        equipamentoForm.getModelo(),
                        equipamentoForm.getIdLocal(),
                        equipamentoForm.getProprietario()
                );
        switch (equipamentoForm.getTipoEquipamento()) {
            case MONITOR:
                return equipamentoFactory.criaMonitor(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getPolegadas()
                );
            case COMPUTADOR:
                return equipamentoFactory.criaComputador(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getProcessador(),
                        equipamentoForm.getMemoria(),
                        equipamentoForm.getHd()
                );
            case TECLADO:
                return equipamentoFactory.criaTeclado(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getTipoConexao()
                );
            case MOUSE:
                return equipamentoFactory.criaMouse(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getTipoConexao()
                );
            case LEITOR_CHEQUE:
                return equipamentoFactory.criaLeitorCheque(
                        caracteristicasBasicasEquipamento
                        );
            case TELEFONE:
                return equipamentoFactory.criaTelefone(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getSemFio(),
                        equipamentoForm.getIp()
                );
            case IMPRESSORA:
                return equipamentoFactory.criaImpressora(
                        caracteristicasBasicasEquipamento,
                        equipamentoForm.getColorida(),
                        equipamentoForm.getTipoImpressora()
                );
            default:
                throw new IllegalArgumentException("Não é possivel criar o equipamento com o identificador " + equipamentoForm.getTipoEquipamento());
        }
    }
}
