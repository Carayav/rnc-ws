package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class ComunaValidator  implements DocumentoValidator {
    String elemento = "Comuna";

    @Override
    public void validate(Documento documento) {
        Integer comuna = documento.getHeaderDoc().getPaciente().getUbicacion().getComuna();
        if (comuna == null || comuna == 0) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
        Boolean isValid = comuna > 1100 && comuna < 16306 || comuna == 99999;
        if (!isValid) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
