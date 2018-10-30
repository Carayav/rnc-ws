package cl.minsal.api.ws.validator;

import cl.minsal.api.types.Documento;

public interface DocumentoValidator {
    void validate(Documento documento) throws ValidationException;
}
