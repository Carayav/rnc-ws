package cl.minsal.api.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Paciente implements Serializable {
	
	public Paciente() {
		
	}
	
	public Paciente(cl.minsal.api.types.Documento docu) {
		cl.minsal.api.types.Paciente paciente = docu.getHeaderDoc().getPaciente();
		cl.minsal.api.types.DatosDemograficos datosDem = docu.getBodyDoc().getDiagnosticoDoc().
				getDatosDemograficos();
		this.fecha_nacimiento = paciente.getFechaDeNacimiento().toGregorianCalendar().getTime();
		this.nombre = paciente.getNombre();
		this.apellido1 = paciente.getPrimerApellido();
		this.apellido2 = paciente.getSegundoApellido();
		this.rut = Integer.parseInt(paciente.getRUT().
						substring(0,paciente.getRUT().length() - 2 ));
		this.dverificador = paciente.getRUT().
				substring(paciente.getRUT().length() - 1 );
		if (paciente.getGenero().intValue() != 0){
			this.genero = paciente.getGenero().intValue();
		}
		//Correcion InCancer
		if(datosDem.getNacionalidad() != null || datosDem.getNacionalidad() != 0){
			this.nacionalidad = datosDem.getNacionalidad();
		}
		if(datosDem.getPuebloOriginario() != null && datosDem.getPuebloOriginario() != 0)  {
			this.pueblo_originario = datosDem.getPuebloOriginario();
		}
		if(datosDem.getEstadoConyugal() != null && datosDem.getEstadoConyugal() != 0){
		this.estado_conyugal = datosDem.getEstadoConyugal();
		}
		if(datosDem.getReligionCulto() != null && datosDem.getReligionCulto() != 0){
			this.religion = datosDem.getReligionCulto();
		}
		if (datosDem.getNivelInstruccion() != null && datosDem.getNivelInstruccion() != 0){
			this.nivel_instruccion = datosDem.getNivelInstruccion();
		}
		if (datosDem.getOcupacion() != null && datosDem.getOcupacion() != 0){
			this.ocupacion = datosDem.getOcupacion();
		}
		if (datosDem.getActividadEconomica() != null && datosDem.getActividadEconomica() != 0){
			this.actividad_economica = datosDem.getActividadEconomica();
		}
		if (datosDem.getPrevision() != null){
			this.prevision = datosDem.getPrevision();
		}
		if(this.prevision == 1){
			if (((int)datosDem.getBeneficiarioFonasa().toUpperCase().charAt(0)-64) != 0){
				this.beneficiario_fonasa = ((int)datosDem.getBeneficiarioFonasa().toUpperCase().charAt(0)-64);
			}
		}

	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_paciente;
	private Integer rut;
	private String dverificador;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fecha_nacimiento;
	private Integer genero;
	private Integer nacionalidad;
	private Integer pueblo_originario;
	private Integer estado_conyugal;
	private Integer religion;
	private Integer nivel_instruccion;
	private Integer ocupacion;
	private Integer actividad_economica;
	private Integer prevision;
	private Integer beneficiario_fonasa;
	private Timestamp fecha_registro;

    @JoinColumn(name = "id_localizacion")
    @OneToOne
    private Localizacion localizacion;

	@OneToMany(mappedBy="paciente")
	private Set<Diagnostico> diagnostico;
	
	public Localizacion getLocalizacion(){
		return localizacion;
	}
	
	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}
	
	public Set<Diagnostico> getDiagnostico() {
		return diagnostico;
	}
	
	public Integer getId_paciente(){
		return id_paciente;
	}

	public Integer getRut() {
		return rut;
	}

	public String getDverificador() {
		return dverificador;
	}
	
	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public void setDverificador(String dverificador) {
		this.dverificador = dverificador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public void setNacionalidad(Integer nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setPueblo_originario(Integer pueblo_originario) {
		this.pueblo_originario = pueblo_originario;
	}

	public void setEstado_conyugal(Integer estado_conyugal) {
		this.estado_conyugal = estado_conyugal;
	}

	public void setReligion(Integer religion) {
		this.religion = religion;
	}

	public void setNivel_instruccion(Integer nivel_instruccion) {
		this.nivel_instruccion = nivel_instruccion;
	}

	public void setOcupacion(Integer ocupacion) {
		this.ocupacion = ocupacion;
	}

	public void setActividad_economica(Integer actividad_economica) {
		this.actividad_economica = actividad_economica;
	}

	public void setDiagnostico(Set<Diagnostico> diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getNombre() {
		return nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public Integer getGenero() {
		return genero;
	}


	public Integer getNacionalidad() {
		return nacionalidad;
	}


	public Integer getPueblo_originario() {
		return pueblo_originario;
	}


	public Integer getEstado_conyugal() {
		return estado_conyugal;
	}


	public Integer getReligion() {
		return religion;
	}


	public Integer getNivel_instruccion() {
		return nivel_instruccion;
	}


	public Integer getOcupacion() {
		return ocupacion;
	}


	public Integer getActividad_economica() {
		return actividad_economica;
	}

	public Integer getPrevision() {
		return prevision;
	}

	public void setPrevision(Integer prevision) {
		this.prevision = prevision;
	}

	public Integer getBeneficiario_fonasa() {
		return beneficiario_fonasa;
	}

	public void setBeneficiario_fonasa(Integer beneficiario_fonasa) {
		this.beneficiario_fonasa = beneficiario_fonasa;
	}

	public Timestamp getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Timestamp fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

}
