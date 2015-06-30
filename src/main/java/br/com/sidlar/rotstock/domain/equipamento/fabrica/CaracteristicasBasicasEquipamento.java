package br.com.sidlar.rotstock.domain.equipamento.fabrica;

import br.com.sidlar.rotstock.domain.equipamento.Fabricante;
import br.com.sidlar.rotstock.domain.equipamento.Proprietario;

public class CaracteristicasBasicasEquipamento {
    private Integer id;
    private String serial;
    private Fabricante fabricante;
    private String modelo;
    private int idLocal;
    private Proprietario proprietario;

    public CaracteristicasBasicasEquipamento(Integer id,String serial, Fabricante fabricante, String modelo, int idLocal, Proprietario proprietario) {
        this.id = id;
        this.serial = serial;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.idLocal = idLocal;
        this.proprietario = proprietario;
    }

    public Integer getId() {
        return id;
    }

    public String getSerial() {
        return serial;
    }

    public Fabricante getFabricante() {
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
