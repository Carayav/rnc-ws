package cl.minsal.api.ws.endpoint.datalayer;

import cl.minsal.api.model.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class PacienteData {

    private Timestamp timestamp;

    public void save(cl.minsal.api.types.Documento docu){
        Transaction tx1 = null;
        Session session = null;
        timestamp = new Timestamp((new Date()).getTime());

        try {
        	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            Paciente paciente = new Paciente(docu);
            paciente.setFecha_registro(timestamp);

            Diagnostico diag = new Diagnostico(docu);
            diag.setFecha_registro(timestamp);

            Medico medico = (new Medico(docu));
            medico.setFecha_registro(timestamp);

            List<Tratamiento> tratamientos = new ArrayList();
            List<cl.minsal.api.types.Tratamiento> ts  = docu.getBodyDoc().getResolucionTratamientoDoc().getTratamientos().getTratamiento();
            Tratamiento tra;
            for (cl.minsal.api.types.Tratamiento t : ts) {
                tra = new Tratamiento(docu, t);
                tra.setFecha_registro(this.timestamp);
                tratamientos.add(tra);
            }

            System.out.println("");
            tx1 = session.beginTransaction();
            Criteria criteria = session.createCriteria(Paciente.class);
            criteria.add(Restrictions.eq("rut", paciente.getRut()));
            //TODO ARREGLAR
            Paciente findPaciente = (Paciente) criteria.setMaxResults(1).uniqueResult();


            // Gson gson = new GsonBuilder().setPrettyPrinting().create();
            // JsonParser jp = new JsonParser();
            // Marshaller jaxbMarshaller = DocXmlToJson.getMarshaller();
            // StringWriter stringWriter = new StringWriter();
            // try {
            //     jaxbMarshaller.marshal(docu, stringWriter);
            // } catch (JAXBException e) {
            //     e.printStackTrace();
            // }
            // JsonElement je = jp.parse(stringWriter.toString());
            // String prettyJsonString = gson.toJson(je);
            // System.out.println(prettyJsonString);

//            Documentos docJson = new Documentos(prettyJsonString);


            if (findPaciente == null) {
                session.save(paciente);
                diag.setPaciente(paciente);
//                docJson.setPaciente(paciente);
            } else {
                diag.setPaciente(findPaciente);
//                docJson.setPaciente(findPaciente);
            }
            Criteria critEstblecimiento = session.createCriteria(Establecimiento.class);
            critEstblecimiento.add(Restrictions.eq("codigo_establecimiento", docu.getHeaderDoc().getCreadorDocumento().getEstablecimiento().getCodigoEstablecimiento()));
            Establecimiento establecimiento = (Establecimiento) critEstblecimiento.setMaxResults(1).uniqueResult();
            System.out.printf(establecimiento.toString());
            //medico.setId_establecimiento(establecimiento.getId());

            session.save(medico);
            for(Tratamiento t: tratamientos){
                t.setDiagnostico(diag);
                t.setMedico(medico);
            }
            session.save(diag);
            for(Tratamiento t: tratamientos){
                session.save(t);
            }


            tx1.commit();

        } catch (Exception e ) {
            e.printStackTrace();
            tx1.rollback();
        } finally {
            session.close();
        }
    }
}
