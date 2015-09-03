package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Finalidade;
import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.StatusItemEstoqueRotativo;
import br.com.sidlar.rotstock.domain.equipamento.Equipamento;

public class ItemEstoqueRotativoForm {
    private String defeito;
    private Finalidade finalidade;
    private Equipamento equipamento;
    private StatusItemEstoqueRotativo status;
    private TipoEquipamento tipoEquipamento;
    private Local local;

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public Finalidade getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(Finalidade finalidade) {
        this.finalidade = finalidade;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public StatusItemEstoqueRotativo getStatus() {
        return status;
    }

    public void setStatus(StatusItemEstoqueRotativo status) {
        this.status = status;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
