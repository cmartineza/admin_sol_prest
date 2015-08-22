/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author MARA
 */
@FacesValidator("validator.letrasydigitos")
public class LetrasYDigitosValidator implements Validator {

    public static final String PARTNER_LETTERS_Y_DIGITS = "([A-Za-z\\d]+)";

    private Pattern pattern;
    private Matcher matcher;

    public LetrasYDigitosValidator() {
        pattern = Pattern.compile(PARTNER_LETTERS_Y_DIGITS);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value != null) {
            matcher = pattern.matcher(value.toString());
            if (!matcher.matches()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error " + component.getAttributes().get("label").toString(), "Ingresar letras y numeros");
                throw new ValidatorException(message);
            }
        }
    }
}
