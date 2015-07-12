package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.equipamento.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EquipamentoForm {
    private Integer id;

    @Size(min=2, max=15, message = "* O serial deve possuir entre 2 e 15 caracteres")
    private String serial;

    @NotNull(message = "* Campo Obrigatório, selecione uma das opções")
    private Fabricante fabricante;

    @Size(min=1 , message = "* Insira um modelo")
    private String modelo;

    @NotNull(message = "* Campo Obrigatório, selecione uma das opções")
    private Proprietario proprietario;

    @NotNull(message = "* Campo Obrigatório, selecione uma das opções")
    private Integer idLocal;

    private Local local;

    private TipoEquipamento tipoEquipamento;

    private Processador processador;

    private Memoria memoria;

    private Hd hd;

    private Boolean colorida;

    private TipoImpressora tipoImpressora;

    private Polegadas polegadas;

    private TipoConexao tipoConexao;

    private Boolean semFio;

    private Boolean ip;

    private String labelBotao;

    private String labelPrincipal;

    private String informacoesEspecificas;

    public EquipamentoForm() {
    }
    public EquipamentoForm(Integer id, String serial, Fabricante fabricante, String modelo, Integer idLocal, String informacoesEspecificas, TipoEquipamento tipoEquipamento) {
        this.id = id;
        this.serial = serial;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.idLocal = idLocal;
        this.informacoesEspecificas = informacoesEspecificas;
        this.tipoEquipamento = tipoEquipamento;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public Processador getProcessador() {
        return processador;
    }

    public void setProcessador(Processador processador) {
        this.processador = processador;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public Hd getHd() {
        return hd;
    }

    public void setHd(Hd hd) {
        this.hd = hd;
    }

    public Boolean getColorida() {
        return colorida;
    }

    public void setColorida(Boolean colorida) {
        this.colorida = colorida;
    }

    public TipoImpressora getTipoImpressora() {
        return tipoImpressora;
    }

    public void setTipoImpressora(TipoImpressora tipoImpressora) {
        this.tipoImpressora = tipoImpressora;
    }

    public Polegadas getPolegadas() {
        return polegadas;
    }

    public void setPolegadas(Polegadas polegadas) {
        this.polegadas = polegadas;
    }

    public TipoConexao getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(TipoConexao tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    public Boolean getSemFio() {
        return semFio;
    }

    public void setSemFio(Boolean semFio) {
        this.semFio = semFio;
    }

    public Boolean getIp() {
        return ip;
    }

    public void setIp(Boolean ip) {
        this.ip = ip;
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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getLabelPrincipal() {
        return labelPrincipal;
    }

    public void setLabelPrincipal(String labelPrincipal) {
        this.labelPrincipal = labelPrincipal;
    }
}
