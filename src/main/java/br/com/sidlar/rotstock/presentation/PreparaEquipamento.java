package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PreparaEquipamento {

//Fica nulo ???
//    @Autowired
//    private LocalRepository localRepository;

    private Local local;
    private EquipamentoForm equipamentoForm;

    public PreparaEquipamento() {
    }

    public PreparaEquipamento(EquipamentoForm equipamentoForm,Local local) {
        this.equipamentoForm = equipamentoForm;
        this.local = local;
    }

    public Equipamento getEquipamentoPreparado(){
        if(isMonitor()) {
            Monitor e = new Monitor(
                    equipamentoForm.getSerial(),
                    equipamentoForm.getFabricante(),
                    equipamentoForm.getModelo(),
                    local,
                    equipamentoForm.getProprietario(),
                    equipamentoForm.getPolegadas()
            );

            return e;
        }
//        }else if(isComputador()){
//            return new Computador(equipamentoForm.getProcessador(),equipamentoForm.getMemoria(),equipamentoForm.getHd());
//        }else if (isTeclado()) {
//            return new Teclado(equipamentoForm.getTipoConexao());
//        }else if (isMouse()) {
//            return new Mouse(equipamentoForm.getTipoConexao());
//        }else if(isLeitorCheque()){
//            return new LeitorCheque();
//        }else if (isTelefone()) {
//            return  new Telefone(equipamentoForm.getIp(),equipamentoForm.getSemFio());
//        }else if (isImpressora()) {
//            return  new Impressora(equipamentoForm.getColorida(),equipamentoForm.getTipoImpressora());
//        }

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

    public EquipamentoForm getEquipamentoForm() {
        return equipamentoForm;
    }

    public void setEquipamentoForm(EquipamentoForm equipamentoForm) {
        this.equipamentoForm = equipamentoForm;
    }
}
