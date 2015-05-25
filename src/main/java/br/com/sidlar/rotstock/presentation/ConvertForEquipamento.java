package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.stereotype.Component;

@Component
public class ConvertForEquipamento {

    private Local local;
    private EquipamentoForm equipamentoForm;

    public ConvertForEquipamento() {
    }
    public ConvertForEquipamento(EquipamentoForm equipamentoForm, Local local) {
        this.equipamentoForm = equipamentoForm;
        this.local = local;
    }
    public Equipamento getEquipamento(){
        if(isMonitor()) {
            return new Monitor(
                    equipamentoForm.getSerial(),
                    equipamentoForm.getFabricante(),
                    equipamentoForm.getModelo(),
                    local,
                    equipamentoForm.getProprietario(),
                    equipamentoForm.getPolegadas()
            );
        }else if(isComputador()){
            return new Computador(
                    equipamentoForm.getSerial(),
                    equipamentoForm.getFabricante(),
                    equipamentoForm.getModelo(),
                    local,
                    equipamentoForm.getProprietario(),
                    equipamentoForm.getProcessador(),
                    equipamentoForm.getMemoria(),
                    equipamentoForm.getHd()
            );
        }else if (isTeclado()) {
            return new Teclado(
                    equipamentoForm.getSerial(),
                    equipamentoForm.getFabricante(),
                    equipamentoForm.getModelo(),
                    local,
                    equipamentoForm.getProprietario(),
                    equipamentoForm.getTipoConexao()
            );
        }else if (isMouse()) {
            return new Mouse(
                    equipamentoForm.getSerial(),
                    equipamentoForm.getFabricante(),
                    equipamentoForm.getModelo(),
                    local,
                    equipamentoForm.getProprietario(),
                    equipamentoForm.getTipoConexao()
            );
        }else if(isLeitorCheque()){
            return new LeitorCheque(
                    equipamentoForm.getSerial(),
                    equipamentoForm.getFabricante(),
                    equipamentoForm.getModelo(),
                    local,
                    equipamentoForm.getProprietario()
            );
        }else if (isTelefone()) {
            return  new Telefone(
                    equipamentoForm.getSerial(),
                    equipamentoForm.getFabricante(),
                    equipamentoForm.getModelo(),
                    local,
                    equipamentoForm.getProprietario(),
                    equipamentoForm.getSemFio(),
                    equipamentoForm.getIp()
            );
        }else if (isImpressora()) {
            return  new Impressora(
                    equipamentoForm.getSerial(),
                    equipamentoForm.getFabricante(),
                    equipamentoForm.getModelo(),
                    local,
                    equipamentoForm.getProprietario(),
                    equipamentoForm.getColorida(),
                    equipamentoForm.getTipoImpressora()
            );
        }
        return null;
    }
    private Boolean isMonitor() {
       return equipamentoForm.getTipoEquipamento() == TipoEquipamento.MONITOR?true:false;
    }
    private Boolean isComputador() {
        return equipamentoForm.getTipoEquipamento() == TipoEquipamento.COMPUTADOR?true:false;
    }
    private Boolean isTeclado() {
        return equipamentoForm.getTipoEquipamento() == TipoEquipamento.TECLADO?true:false;
    }
    private Boolean isMouse(){
        return equipamentoForm.getTipoEquipamento() == TipoEquipamento.MOUSE?true:false;
    }
    private Boolean isLeitorCheque(){
        return equipamentoForm.getTipoEquipamento() == TipoEquipamento.LEITOR_CHEQUE?true:false;
    }
    private Boolean isTelefone() {
        return equipamentoForm.getTipoEquipamento() == TipoEquipamento.TELEFONE?true:false;
    }
    private Boolean isImpressora() {
        return equipamentoForm.getTipoEquipamento() == TipoEquipamento.IMPRESSORA?true:false;
    }
}
