package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipamento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
abstract public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serial;

    @Enumerated(EnumType.STRING)
    private Fabricante fabricante;
    private String modelo;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_local")
    private Local local;

    @Enumerated(EnumType.STRING)
    private Proprietario proprietario;

    public Equipamento() {
    }

    public Equipamento(Integer id, String serial, Fabricante fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario) {
        this.id = id;
        this.serial = serial;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.ativo = ativo;
        this.local = local;
        this.proprietario = proprietario;
    }
    public String getSerial() {
        return serial;
    }

    public Integer getId() {
        return id;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public Local getLocal() {
        return local;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    abstract public TipoEquipamento getTipoEquipamento();

    abstract public String getInformacoesEspecificas();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipamento)) return false;
        Equipamento that = (Equipamento) o;
        return Objects.equals(serial, that.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial);
    }
}