package br.com.dac.validador;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by diogomoreira on 06/09/16.
 */
@FacesValidator("cpfValidador")
public class CPFValidador implements Validator{

    private CPFValidator validator = new CPFValidator();

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent,
                         Object o) throws ValidatorException {
        try {
            validator.assertValid(o.toString());
        } catch (InvalidStateException e) {
            throw new ValidatorException(new FacesMessage("Erro", "CPF " +
                    "inválido"));
        }
    }
}
