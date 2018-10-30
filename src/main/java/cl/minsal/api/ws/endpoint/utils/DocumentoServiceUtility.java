package cl.minsal.api.ws.endpoint.utils;

import cl.minsal.api.ws.Services.DocumentoService;
import cl.minsal.api.ws.validator.DocumentoValidator;
import cl.minsal.api.ws.validator.rules.*;

import java.util.Arrays;

public class DocumentoServiceUtility {
    public static DocumentoService docSrv;


/*
*
Nacionalidad  integer 3 Recomendable
Pueblo Originario integer 2 Recomendable
Estado Conyugal integer 1 Recomendable
Religión o Culto  integer 2 Recomendable
Nivel de Instrucción  integer 2 Recomendable
Ocupación integer 2 Recomendable
Actividad Económica Integer 2 Recomendable
Dirección varchar 50  Recomendable
Diagnóstico - Tratamiento




Diagnóstico Comité  Varchar 50  Recomendable
Nombre Médico Tratante  varchar 50  Recomendable
Tipo Tratamiento  integer 1 Recomendable
Intención del tratamiento integer 1 Recomendable
Fecha de Intención del tratamiento  Date  8 Recomendable
Descripcíon Tratamiento - Resolución Comité clob    Recomendable



    *
    *
    * */

    public static synchronized DocumentoService getDocSrv(){
        if(docSrv == null){
            docSrv = new DocumentoService(Arrays.<DocumentoValidator>asList(
                    new RutValidator(),
                    new NombreValidator(),
                    new PrimerApellidoValidator(),
                    new SegundoApellidoValidator(),
                    new FechaDeNacimientoValidator(),
                    new GeneroValidator(),
                    new CreadorNombreEstablecimientoValidator(),
                    new CreadorCodigoEstablecimientoValidator(),
                    new CreadorServicioSaludValidator(),
                    new MedicoTratanteValidator(),
                    new ResolucionComiteValidator(),
                    new BeneficiarioValidator(),
                    new PrevisionValidator(),
                    new RegionValidator(),
                    new ProvinciaValidator(),
                    new ComunaValidator(),
                    new TipoComiteValidator(),
                    new FechaDiagnosticoValidator(),
                    new FechaComiteValidator(),
                    new DiagnosticoCIE10(),
                    new ECOGValidator(),
                    new TNMValidator(),
                    new EstadioValidator()
            ));
        }
        return docSrv;
    }
}
