package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.equipamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscaPorEquipamentoForm {
    @Autowired
    EquipamentoToEquipamentoFormConverter convertEquipamentoForm;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    public List<EquipamentoForm> getEquipamentos(EquipamentoForm equipamentoForm){
        List<EquipamentoForm> retorno;

        boolean consultaComSerial = !equipamentoForm.getSerial().equalsIgnoreCase("");
        boolean consultaComLocal = equipamentoForm.getIdLocal() != null;
        boolean consultaComTipoEquipamento = equipamentoForm.getTipoEquipamento() != null;

        if(consultaComSerial){
            retorno =  convertEquipamentoForm.getEquipamentoForm(equipamentoRepository.buscaPorSerial(equipamentoForm.getSerial()));

        }else if(consultaComLocal & consultaComTipoEquipamento){
            retorno = convertEquipamentoForm.getEquipamentoForm(equipamentoRepository.buscaPorTipoEquipamentoLocal(
                    classPorTipoEquipamento(equipamentoForm.getTipoEquipamento()),equipamentoForm.getIdLocal()
            ));
        }else if (consultaComLocal) {
           retorno = convertEquipamentoForm.getEquipamentoForm(equipamentoRepository.buscaPorLocal(equipamentoForm.getIdLocal()));
        }else if (consultaComTipoEquipamento) {
            retorno = convertEquipamentoForm.getEquipamentoForm(
                            equipamentoRepository.buscaPorTipoEquipamento(
                                    classPorTipoEquipamento(
                                            equipamentoForm.getTipoEquipamento())));
        }else{
            retorno = convertEquipamentoForm.getEquipamentoForm(equipamentoRepository.buscaTodos());
        }

        return retorno;
    }

    private Class classPorTipoEquipamento(TipoEquipamento tipoEquipamento) {
        switch (tipoEquipamento){
            case COMPUTADOR:
                return Computador.class;
            case MONITOR:
                return Monitor.class;
            case IMPRESSORA:
                return Impressora.class;
            case LEITOR_CHEQUE:
                return LeitorCheque.class;
            case TECLADO:
                return Teclado.class;
            case MOUSE:
                return  Mouse.class;
            case TELEFONE:
                return Telefone.class;
            default:
                throw new IllegalArgumentException("Não é possivel buscar o equipamento com o identificador " + tipoEquipamento);
        }
    }


}
