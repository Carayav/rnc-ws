package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class TipoComiteValidator implements DocumentoValidator {
    String elemento = "TipoComite";

    @Override
    public void validate(Documento documento) {
        Integer tipoComite = Integer.parseInt(documento.getBodyDoc().getDiagnosticoDoc().getDiagnostico().getTipoComite());
        if (tipoComite == null || tipoComite == 0) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
        Boolean isValid = tipoComite > 0 && tipoComite < 31 ;
        if(!isValid){
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}

