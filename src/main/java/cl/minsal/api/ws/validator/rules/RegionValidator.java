package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class RegionValidator implements DocumentoValidator {
    String elemento = "Region";

    @Override
    public void validate(Documento documento) {
        Integer region = documento.getHeaderDoc().getPaciente().getUbicacion().getRegion();
        if (region == null || region == 0) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
        Boolean isValid = region > 0 && region < 17 || region == 99;
        if(!isValid){
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
