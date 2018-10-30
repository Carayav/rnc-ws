package cl.minsal.api.ws.Services;

import cl.minsal.api.types.Documento;
import cl.minsal.api.ws.validator.DocumentoValidator;

import java.util.List;

public class DocumentoService {
    private final List<DocumentoValidator> validators;

    public DocumentoService(List<DocumentoValidator> validators) {
        this.validators = validators;
    }


    public void validate(Documento documento) {
        for (DocumentoValidator validator:validators) {
            validator.validate(documento);
        }
    }
}
