package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

public class EquipamentoModel {
    private Integer id;

    private String serial;

    private Fabricante fabricante;

    private String modelo;

    private Proprietario proprietario;

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

    private String informacoesEspecificas;

    public EquipamentoModel() {
    }

    public EquipamentoModel(Integer id, String serial, Fabricante fabricante, String modelo, Proprietario proprietario, Integer idLocal, Local local, TipoEquipamento tipoEquipamento, Processador processador, Memoria memoria, Hd hd, Boolean colorida, TipoImpressora tipoImpressora, Polegadas polegadas, TipoConexao tipoConexao, Boolean semFio, Boolean ip) {
        this.id = id;
        this.serial = serial;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.proprietario = proprietario;
        this.idLocal = idLocal;
        this.local = local;
        this.tipoEquipamento = tipoEquipamento;
        this.processador = processador;
        this.memoria = memoria;
        this.hd = hd;
        this.colorida = colorida;
        this.tipoImpressora = tipoImpressora;
        this.polegadas = polegadas;
        this.tipoConexao = tipoConexao;
        this.semFio = semFio;
        this.ip = ip;
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

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
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

    public String getInformacoesEspecificas() {
        return informacoesEspecificas;
    }

    public void setInformacoesEspecificas(String informacoesEspecificas) {
        this.informacoesEspecificas = informacoesEspecificas;
    }
}
