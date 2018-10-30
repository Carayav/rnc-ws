package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

import javax.xml.datatype.XMLGregorianCalendar;

public class PrevisionValidator implements DocumentoValidator {
    String elemento = "Prevision";
    @Override
    public void validate(Documento documento) {
        Integer prevision = documento.getBodyDoc().getDiagnosticoDoc().getDatosDemograficos().getPrevision();
        if (prevision == null || prevision == 0){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
        Boolean isValid = prevision == 1 ||
                prevision == 2 ||
                prevision == 3 ||
                prevision == 5 ||
                prevision == 6 ||
                prevision == 7 ||
                prevision == 9 ;
        if(!isValid){
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }

    }
}