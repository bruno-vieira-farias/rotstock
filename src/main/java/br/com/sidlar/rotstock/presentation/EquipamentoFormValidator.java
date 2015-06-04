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
        if (equipamentoForm.getTipoEquipamento() == TipoEquipamento.MONITOR) {
            if (equipamentoForm.getPolegadas() == null) {
                errors.rejectValue("polegadas", "field.required", "Opaaaaa");
            }
        }
    }
}
