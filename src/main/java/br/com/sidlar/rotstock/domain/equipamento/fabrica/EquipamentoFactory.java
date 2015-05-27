package br.com.sidlar.rotstock.domain.equipamento.fabrica;


import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoFactory {
    @Autowired
    private LocalRepository localRepository;

    public Equipamento criaImpressora(CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento, Boolean colorida, TipoImpressora tipoImpressora) {
        return new Impressora(
                caracteristicasBasicasEquipamento.getSerial(),
                caracteristicasBasicasEquipamento.getFabricante(),
                caracteristicasBasicasEquipamento.getModelo(),
                true,
                localRepository.buscaPorId(caracteristicasBasicasEquipamento.getIdLocal()),
                caracteristicasBasicasEquipamento.getProprietario(),
                colorida,
                tipoImpressora);
    }
    public Equipamento criaTelefone(CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento, Boolean semFio, Boolean ip) {
        return new Telefone(
                caracteristicasBasicasEquipamento.getSerial(),
                caracteristicasBasicasEquipamento.getFabricante(),
                caracteristicasBasicasEquipamento.getModelo(),
                true,
                localRepository.buscaPorId(caracteristicasBasicasEquipamento.getIdLocal()),
                caracteristicasBasicasEquipamento.getProprietario(),
                semFio ,
                ip);
    }
    public Equipamento criaLeitorCheque(CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento) {
        return new LeitorCheque(
                caracteristicasBasicasEquipamento.getSerial(),
                caracteristicasBasicasEquipamento.getFabricante(),
                caracteristicasBasicasEquipamento.getModelo(),
                true,
                localRepository.buscaPorId(caracteristicasBasicasEquipamento.getIdLocal()),
                caracteristicasBasicasEquipamento.getProprietario());
    }
    public Equipamento criaMouse(CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento, TipoConexao tipoConexao) {
        return new Mouse(
                caracteristicasBasicasEquipamento.getSerial(),
                caracteristicasBasicasEquipamento.getFabricante(),
                caracteristicasBasicasEquipamento.getModelo(),
                true,
                localRepository.buscaPorId(caracteristicasBasicasEquipamento.getIdLocal()),
                caracteristicasBasicasEquipamento.getProprietario(),
                tipoConexao);
    }
    public Equipamento criaTeclado(CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento, Enum<TipoConexao> tipoConexao) {
        return new Teclado(
                caracteristicasBasicasEquipamento.getSerial(),
                caracteristicasBasicasEquipamento.getFabricante(),
                caracteristicasBasicasEquipamento.getModelo(),
                true,
                localRepository.buscaPorId(caracteristicasBasicasEquipamento.getIdLocal()),
                caracteristicasBasicasEquipamento.getProprietario(),
                tipoConexao);
    }
    public Equipamento criaComputador(CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento, Processador processador, Memoria memoria, Hd hd) {
        return new Computador(
                caracteristicasBasicasEquipamento.getSerial(),
                caracteristicasBasicasEquipamento.getFabricante(),
                caracteristicasBasicasEquipamento.getModelo(),
                true,
                localRepository.buscaPorId(caracteristicasBasicasEquipamento.getIdLocal()),
                caracteristicasBasicasEquipamento.getProprietario(),
                processador,
                memoria,
                hd);
    }
    public Equipamento criaMonitor(CaracteristicasBasicasEquipamento caracteristicasBasicasEquipamento, Polegadas polegadas) {
        return new Monitor(caracteristicasBasicasEquipamento.getSerial(),
                caracteristicasBasicasEquipamento.getFabricante(),
                caracteristicasBasicasEquipamento.getModelo(),
                true,
                localRepository.buscaPorId(caracteristicasBasicasEquipamento.getIdLocal()),
                caracteristicasBasicasEquipamento.getProprietario(),
                polegadas);
    }
}
