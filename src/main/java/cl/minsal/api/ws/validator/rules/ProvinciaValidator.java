package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class ProvinciaValidator  implements DocumentoValidator {
    String elemento = "Provincia";

    @Override
    public void validate(Documento documento) {
        Integer provincia = documento.getHeaderDoc().getPaciente().getUbicacion().getProvincia();
        if (provincia == null ) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
        Boolean isValid = provincia > 10 && provincia < 164 || provincia == 999;
        if (!isValid) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}