package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

import javax.xml.datatype.XMLGregorianCalendar;

public class FechaDiagnosticoValidator implements DocumentoValidator {
    String elemento = "FechDiagnostico";
    @Override
    public void validate(Documento documento) {
        XMLGregorianCalendar fechaDiagnostico = documento.getBodyDoc().getDiagnosticoDoc().getDiagnostico().getFechaDiagnostico();
        if (fechaDiagnostico == null){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
    }
}