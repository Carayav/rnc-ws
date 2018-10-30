package cl.minsal.api.ws.validator.rules;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.endpoint.ErrorCodes;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.ValidationException;

public class CreadorServicioSaludValidator implements DocumentoValidator {
    String elemento = "ServicioSalud";

    @Override
    public void validate(Documento documento) {
        Integer servicio_salud = documento.getHeaderDoc().getCreadorDocumento().getEstablecimiento().getServicioSalud();
        if (servicio_salud == null || servicio_salud == 0) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (servicio_salud != 9) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
