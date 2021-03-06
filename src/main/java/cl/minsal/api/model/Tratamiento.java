package cl.minsal.api.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tratamiento implements Serializable {
	
	public Tratamiento(){}

	public Tratamiento(cl.minsal.api.types.Documento doc, cl.minsal.api.types.Tratamiento tratamiento){
	    if(doc.getBodyDoc().getResolucionTratamientoDoc().getTratamientoGeneral().getResolucionComite() != null && doc.getBodyDoc().getResolucionTratamientoDoc().getTratamientoGeneral().getResolucionComite().length() > 1){
            this.resolucion_comite = Integer.parseInt(doc.getBodyDoc().getResolucionTratamientoDoc().getTratamientoGeneral().getResolucionComite());
        }

        if(tratamiento.getTipoTratamiento() != 0) {
            this.tipo_tratamiento = tratamiento.getTipoTratamiento();
        }
        if(tratamiento.getIntencionTratamiento() != 0) {
            this.intencion_tratamiento = tratamiento.getIntencionTratamiento();
        }

		//Correcion InCancer
		if(tratamiento.getFechaIntencion() != null ){
			this.fecha_intencion = tratamiento.getFechaIntencion().toGregorianCalendar().getTime();
		}

		this.descripcion_tratamiento = doc.getBodyDoc().
				getResolucionTratamientoDoc().
				getTratamientoGeneral().
				getDescripcionResolucionComite();
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_tratamiento;
	private String descripcion_tratamiento;
	private Integer resolucion_comite;
	private Integer tipo_tratamiento;
	private Date fecha_intencion;
	private Integer intencion_tratamiento;
	private Timestamp fecha_registro;
	
	@ManyToOne
    @JoinColumn(name="id_diagnostico", nullable=false)
	private Diagnostico diagnostico;
	
	@ManyToOne
    @JoinColumn(name="id_medico", nullable=false)
	private Medico medico;
	
	public Integer getId_tratamiento() {
		return id_tratamiento;
	}
	public String getDescripcion_tratamiento() {
		return descripcion_tratamiento;
	}
	public Integer getResolucion_comite() {
		return resolucion_comite;
	}
	public Integer getTipo_tratamiento() {
		return tipo_tratamiento;
	}
	public void setTipo_tratamiento(Integer tipo_tratamiento) {
		this.tipo_tratamiento = tipo_tratamiento;
	}
	public Date getFecha_intencion() {
		return fecha_intencion;
	}
	public void setFecha_intencion(Date fecha_intencion) {
		this.fecha_intencion = fecha_intencion;
	}
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public void setDescripcion_tratamiento(String descripcion_tratamiento) {
		this.descripcion_tratamiento = descripcion_tratamiento;
	}
	public void setResolucion_comite(Integer resolucion_comite) {
		this.resolucion_comite = resolucion_comite;
	}
	public Integer getIntencion_tratamiento() {
		return intencion_tratamiento;
	}
	public void setIntencion_tratamiento(Integer intencion_tratamiento) {
		this.intencion_tratamiento = intencion_tratamiento;
	}
	public Timestamp getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Timestamp fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
		
}
