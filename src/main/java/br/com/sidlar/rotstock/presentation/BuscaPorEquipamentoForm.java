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
        boolean consultaComLocal = equipamentoForm.getLocal() != null;
        boolean consultaComTipoEquipamento = equipamentoForm.getTipoEquipamento() != null;

        if(consultaComSerial){
            retorno =  convertEquipamentoForm.getEquipamentosForm(equipamentoRepository.buscaPorSerial(equipamentoForm.getSerial()));

        }else if(consultaComLocal & consultaComTipoEquipamento){
            retorno = convertEquipamentoForm.getEquipamentosForm(equipamentoRepository.buscaPorTipoEquipamentoLocal(
                    classPorTipoEquipamento(equipamentoForm.getTipoEquipamento()), equipamentoForm.getLocal()
            ));
        }else if (consultaComLocal) {
           retorno = convertEquipamentoForm.getEquipamentosForm(equipamentoRepository.buscaPorLocal(equipamentoForm.getLocal()));
        }else if (consultaComTipoEquipamento) {
            retorno = convertEquipamentoForm.getEquipamentosForm(
                    equipamentoRepository.buscaPorTipoEquipamento(
                            classPorTipoEquipamento(
                                    equipamentoForm.getTipoEquipamento())));
        }else{
            retorno = convertEquipamentoForm.getEquipamentosForm(equipamentoRepository.buscaTodos());
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