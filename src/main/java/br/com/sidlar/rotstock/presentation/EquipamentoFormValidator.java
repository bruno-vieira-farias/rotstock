package br.com.sidlar.rotstock.presentation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EquipamentoFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(EquipamentoForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EquipamentoForm equipamentoForm = (EquipamentoForm) target;

        if (equipamentoForm.getTipoEquipamento() == null) {
            errors.rejectValue("tipoEquipamento","field.required","* Campo Obrigatório, escolha uma das opções");
            return;
        }
        switch (equipamentoForm.getTipoEquipamento()){
            case MONITOR:
               validaMonitor(equipamentoForm,errors);
                break;
            case COMPUTADOR:
                validaComputador(equipamentoForm,errors);
                break;

            case IMPRESSORA:
                validaImpressora(equipamentoForm, errors);
                break;

            case TELEFONE:
                validaTelefone(equipamentoForm, errors);
                break;

            case MOUSE:
                validaMouse(equipamentoForm, errors);
                break;

            case TECLADO:
                validaTeclado(equipamentoForm, errors);
                break;
        }
    }
    private void validaTeclado(EquipamentoForm equipamentoForm, Errors errors) {
        if (equipamentoForm.getTipoConexao() == null) {
            errors.rejectValue("tipoConexao","field.required","* Campo Obrigatario, escolha uma das opções");
        }
    }
    private void validaMouse(EquipamentoForm equipamentoForm, Errors errors) {
        if (equipamentoForm.getTipoConexao() == null) {
            errors.rejectValue("tipoConexao","field.required","* Campo Obrigatario, escolha uma das opções");
        }
    }
    private void validaTelefone(EquipamentoForm equipamentoForm, Errors errors) {
        if (equipamentoForm.getIp() == null) {
            errors.rejectValue("ip","field.required","* Campo Obrigatario, escolha uma das opções");
        }
        if (equipamentoForm.getSemFio() == null) {
            errors.rejectValue("semFio","field.required","* Campo Obrigatario, escolha uma das opções");
        }
    }
    private void validaImpressora(EquipamentoForm equipamentoForm, Errors errors) {
        if (equipamentoForm.getColorida() == null) {
            errors.rejectValue("colorida","field.required","* Campo Obrigatario, escolha uma das opções");
        }
        if (equipamentoForm.getTipoImpressora() == null) {
            errors.rejectValue("tipoImpressora","field.required","* Campo Obrigatario, escolha uma das opções");
        }
    }
    private void validaComputador(EquipamentoForm equipamentoForm, Errors errors) {
        if (equipamentoForm.getProcessador() == null) {
            errors.rejectValue("processador","field.required","* Campo Obrigatario, escolha uma das opções");
        }
        if (equipamentoForm.getMemoria() == null) {
            errors.rejectValue("memoria","field.required","* Campo Obrigatario, escolha uma das opções");
        }
        if (equipamentoForm.getHd() == null) {
            errors.rejectValue("hd","field.required","* Campo Obrigatario, escolha uma das opções");
        }
    }
    private void validaMonitor(EquipamentoForm equipamentoForm, Errors errors) {
        if (equipamentoForm.getPolegadas() == null) {
            errors.rejectValue("polegadas", "field.required", "* Campo Obrigatario, escolha uma das opções");
        }
    }
}