package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Finalidade;
import br.com.sidlar.rotstock.domain.StatusItemEstoqueRotativo;
import br.com.sidlar.rotstock.domain.equipamento.TipoEquipamento;

/**
 * Classe que representa o objeto de domino ItemEstoqueRotativo no formulario html do de entrada de equipamentos.
 */

public class ItemEstoqueRotativoForm {
    private String defeito;
    private Finalidade finalidade;
    private EquipamentoForm equipamentoForm;
    private StatusItemEstoqueRotativo status;
    private TipoEquipamento tipoEquipamento;

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

    public EquipamentoForm getEquipamentoForm() {
        return equipamentoForm;
    }

    public void setEquipamentoForm(EquipamentoForm equipamento) {
        this.equipamentoForm = equipamento;
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
}