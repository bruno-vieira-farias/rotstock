package br.com.sidlar.rotstock.domain.equipamento.fabrica;

import br.com.sidlar.rotstock.domain.equipamento.Proprietario;

public class CaracteristicasBasicasEquipamento {
    private String serial;
    private String fabricante;
    private String modelo;
    private int idLocal;
    private Proprietario proprietario;

    public CaracteristicasBasicasEquipamento(String serial, String fabricante, String modelo, int idLocal, Proprietario proprietario) {
        this.serial = serial;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.idLocal = idLocal;
        this.proprietario = proprietario;
    }

    public String getSerial() {
        return serial;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }
}
