package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertToEquipamento {
    @Autowired
    private LocalRepository localRepository;

    public Equipamento getEquipamento(EquipamentoForm equipamentoForm) {
        switch (equipamentoForm.getTipoEquipamento()) {
            case MONITOR:
                return criaMonitor(equipamentoForm);
            case COMPUTADOR:
                return criaComputador(equipamentoForm);
            case TECLADO:
                return  criaTeclado(equipamentoForm);
            case MOUSE:
                return  criaMouse(equipamentoForm);
            case LEITOR_CHEQUE:
                return criaLeitorCheque(equipamentoForm);
            case TELEFONE:
                return criaTelefone(equipamentoForm);
            case IMPRESSORA:
                return criaImpressora(equipamentoForm);
        }
        return null;
    }
    private Equipamento criaImpressora(EquipamentoForm equipamentoForm) {
        return new Impressora(
                equipamentoForm.getSerial(),
                equipamentoForm.getFabricante(),
                equipamentoForm.getModelo(),
                localRepository.buscaPorId(equipamentoForm.getIdLocal()),
                equipamentoForm.getProprietario(),
                equipamentoForm.getColorida(),
                equipamentoForm.getTipoImpressora()
        );
    }
    private Equipamento criaTelefone(EquipamentoForm equipamentoForm) {
        return new Telefone(
                equipamentoForm.getSerial(),
                equipamentoForm.getFabricante(),
                equipamentoForm.getModelo(),
                localRepository.buscaPorId(equipamentoForm.getIdLocal()),
                equipamentoForm.getProprietario(),
                equipamentoForm.getSemFio(),
                equipamentoForm.getIp()
        );
    }
    private Equipamento criaLeitorCheque(EquipamentoForm equipamentoForm) {
        return new LeitorCheque(
                equipamentoForm.getSerial(),
                equipamentoForm.getFabricante(),
                equipamentoForm.getModelo(),
                localRepository.buscaPorId(equipamentoForm.getIdLocal()),
                equipamentoForm.getProprietario()
        );
    }
    private Equipamento criaMouse(EquipamentoForm equipamentoForm) {
            return new Mouse(
                equipamentoForm.getSerial(),
                equipamentoForm.getFabricante(),
                equipamentoForm.getModelo(),
                localRepository.buscaPorId(equipamentoForm.getIdLocal()),
                equipamentoForm.getProprietario(),
                equipamentoForm.getTipoConexao()
        );
    }
    private Equipamento criaTeclado(EquipamentoForm equipamentoForm) {
        return new Teclado(
                equipamentoForm.getSerial(),
                equipamentoForm.getFabricante(),
                equipamentoForm.getModelo(),
                localRepository.buscaPorId(equipamentoForm.getIdLocal()),
                equipamentoForm.getProprietario(),
                equipamentoForm.getTipoConexao()
        );
    }
    private Equipamento criaComputador(EquipamentoForm equipamentoForm) {
        return new Computador(
                equipamentoForm.getSerial(),
                equipamentoForm.getFabricante(),
                equipamentoForm.getModelo(),
                localRepository.buscaPorId(equipamentoForm.getIdLocal()),
                equipamentoForm.getProprietario(),
                equipamentoForm.getProcessador(),
                equipamentoForm.getMemoria(),
                equipamentoForm.getHd()
        );
    }
    private Equipamento criaMonitor(EquipamentoForm equipamentoForm) {
        return new Monitor(
                equipamentoForm.getSerial(),
                equipamentoForm.getFabricante(),
                equipamentoForm.getModelo(),
                localRepository.buscaPorId(equipamentoForm.getIdLocal()),
                equipamentoForm.getProprietario(),
                equipamentoForm.getPolegadas()
        );
    }

}
