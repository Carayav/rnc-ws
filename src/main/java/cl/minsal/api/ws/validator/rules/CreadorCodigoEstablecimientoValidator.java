package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class CreadorCodigoEstablecimientoValidator implements DocumentoValidator {
    String elemento = "CodigoEstablecimiento";
    @Override
    public void validate(Documento documento) {
        Integer codigo_establecimiento = documento.getHeaderDoc().getCreadorDocumento().getEstablecimiento().getCodigoEstablecimiento();
        if (codigo_establecimiento == null || codigo_establecimiento == 0) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (codigo_establecimiento != 109103){
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
