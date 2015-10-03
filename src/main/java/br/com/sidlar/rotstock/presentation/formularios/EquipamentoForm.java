package br.com.sidlar.rotstock.presentation.formularios;

import br.com.sidlar.rotstock.domain.equipamento.EquipamentoEspecificacao;
/**
 * Classe que representa o objeto de domino Equipamento na camada de apresentação.
 */
public class EquipamentoForm {
//  Validações a realizar
//    @Size(min=2, max=15, message = "* O serial deve possuir entre 2 e 15 caracteres")
//    private String serial;
//
//    @NotNull(message = "* Campo Obrigatório, selecione uma das opções")
//    private Fabricante fabricante;
//
//    @Size(min=1 , message = "* Insira um modelo")
//    private String modelo;
//
//    @NotNull(message = "* Campo Obrigatório, selecione uma das opções")
//    private Proprietario proprietario;
//
//    @NotNull(message = "* Campo Obrigatório, selecione uma das opções")
//    private Integer idLocal;
    private EquipamentoEspecificacao equipamentoEspecificacao;
    private String labelBotao;
    private String labelPrincipal;
    private String informacoesEspecificas;

    public EquipamentoForm() {
    }

    public EquipamentoEspecificacao getEquipamentoEspecificacao() {
        return equipamentoEspecificacao;
    }

    public void setEquipamentoEspecificacao(EquipamentoEspecificacao equipamentoEspecificacao) {
        this.equipamentoEspecificacao = equipamentoEspecificacao;
    }

    public String getLabelBotao() {
        return labelBotao;
    }

    public String getInformacoesEspecificas() {
        return informacoesEspecificas;
    }

    public void setLabelBotao(String labelBotao) {
        this.labelBotao = labelBotao;
    }

    public void setInformacoesEspecificas(String informacoesEspecificas) {
        this.informacoesEspecificas = informacoesEspecificas;
    }

    public String getLabelPrincipal() {
        return labelPrincipal;
    }

    public void setLabelPrincipal(String labelPrincipal) {
        this.labelPrincipal = labelPrincipal;
    }
}
