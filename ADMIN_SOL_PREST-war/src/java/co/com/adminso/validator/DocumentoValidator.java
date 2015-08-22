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
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author MARA
 */
@FacesValidator("validator.numeroIdentificacion")
public class DocumentoValidator implements Validator {

    public static final String PARTNER_DOC = "(\\d+)";
    public static final String PARTNER_CE = "([A-Za-z\\d]+)";

    private Pattern pattern;
    private Matcher matcher;

    public DocumentoValidator() {

    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Short tipoId = (Short) ((SelectOneMenu) component.getAttributes().get("tpoDocId")).getValue();
        if (tipoId != null) {
            String patternFinal = (tipoId == 1) ? PARTNER_DOC : PARTNER_CE;
            pattern = Pattern.compile(patternFinal);
            matcher = pattern.matcher(value.toString());
            if (!matcher.matches()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error " + component.getAttributes().get("label").toString(), "Por favor validar e intentar nuevamente");
                throw new ValidatorException(message);
            }
        }
    }
}
