package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mascota
 *
 */
@Entity

public class Mascota implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_mascota;
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private Date fechaNac;
	private int edad;
	private String coloYSenalesParti;
	//Foreings Keys
	//relacion propietario mascota
	@OneToOne(cascade= CascadeType.ALL,mappedBy = "id_historia_mascota")
	private HistoriaClinica mascota;
	//relacion historia clinica mascota
	@OneToOne
	@JoinColumn
	private HistoriaClinica id_historia_mascota;
	
	@ManyToOne
	@JoinColumn
	private Mascota id_mascota_propietario;
	
	public Mascota() {
	}


	

	public Mascota(int id_mascota, String nombre, String especie, String raza, String sexo, Date fechaNac, int edad,
			String coloYSenalesParti, HistoriaClinica mascota, HistoriaClinica id_historia_mascota,
			Mascota id_mascota_propietario) {
		super();
		this.id_mascota = id_mascota;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.edad = edad;
		this.coloYSenalesParti = coloYSenalesParti;
		this.mascota = mascota;
		this.id_historia_mascota = id_historia_mascota;
		this.id_mascota_propietario = id_mascota_propietario;
	}










	public HistoriaClinica getMascota() {
		return mascota;
	}





	public void setMascota(HistoriaClinica mascota) {
		this.mascota = mascota;
	}





	public Mascota getId_mascota_propietario() {
		return id_mascota_propietario;
	}




	public void setId_mascota_propietario(Mascota id_mascota_propietario) {
		this.id_mascota_propietario = id_mascota_propietario;
	}




	public int getId_mascota() {
		return id_mascota;
	}


	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Date getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getColoYSenalesParti() {
		return coloYSenalesParti;
	}


	public void setColoYSenalesParti(String coloYSenalesParti) {
		this.coloYSenalesParti = coloYSenalesParti;
	}


	


	public HistoriaClinica getId_historia_mascota() {
		return id_historia_mascota;
	}


	public void setId_historia_mascota(HistoriaClinica id_historia_mascota) {
		this.id_historia_mascota = id_historia_mascota;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_mascota);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return id_mascota == other.id_mascota;
	}





	@Override
	public String toString() {
		return "Mascota [id_mascota=" + id_mascota + ", nombre=" + nombre + ", especie=" + especie + ", raza=" + raza
				+ ", sexo=" + sexo + ", fechaNac=" + fechaNac + ", edad=" + edad + ", coloYSenalesParti="
				+ coloYSenalesParti + ", mascota=" + mascota + ", id_historia_mascota=" + id_historia_mascota + "]";
	}


	
   
}
