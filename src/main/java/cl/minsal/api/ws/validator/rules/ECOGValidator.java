package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

import java.math.BigInteger;

public class ECOGValidator implements DocumentoValidator {
    String elemento = "ECOG";

    @Override
    public void validate(Documento documento) {
        Integer ecog = documento.getBodyDoc().getDiagnosticoDoc().getDiagnostico().getECOG();
        if (ecog == null) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
        Boolean isValid = ecog >= 0 && ecog < 6;
        if (!isValid) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}