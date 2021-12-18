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
	private String sexo;
	private String fechaNac;
	private String edad;
	private String coloYSenalesParti;
	//Foreings Keys
	//relacion historia mascota
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "mascota_id")
	private  HistoriaClinica historiaClinica;
	
	
	
	//relacion propiertario mascota
	@ManyToOne
	@JoinColumn
	private Propietario id_mascota_propietario;
	
	//relacion especia mascota
	
	@ManyToOne
	@JoinColumn
	private Raza raza_id;
	
	public Mascota() {
	}

	public Mascota(int id_mascota,String nombre, String sexo, String fechaNac,
			String edad, String coloYSenalesParti, Propietario id_mascota_propietario, Raza raza_id) {
		super();
		this.id_mascota=id_mascota;
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.edad = edad;
		this.coloYSenalesParti = coloYSenalesParti;
		this.id_mascota_propietario = id_mascota_propietario;
		this.raza_id = raza_id;
	}

	public Mascota(String nombre, String sexo, String fechaNac,
			String edad, String coloYSenalesParti, Propietario id_mascota_propietario, Raza raza_id) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.edad = edad;
		this.coloYSenalesParti = coloYSenalesParti;
		this.id_mascota_propietario = id_mascota_propietario;
		this.raza_id = raza_id;
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

	


	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getColoYSenalesParti() {
		return coloYSenalesParti;
	}

	public void setColoYSenalesParti(String coloYSenalesParti) {
		this.coloYSenalesParti = coloYSenalesParti;
	}

	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}

	public Propietario getId_mascota_propietario() {
		return id_mascota_propietario;
	}

	public void setId_mascota_propietario(Propietario id_mascota_propietario) {
		this.id_mascota_propietario = id_mascota_propietario;
	}

	public Raza getEspecie_id() {
		return raza_id;
	}

	public void setRaza_id(Raza raza_id) {
		this.raza_id = raza_id;
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
		return "Mascota [id_mascota=" + id_mascota + ", nombre=" + nombre + ", sexo=" + sexo + ", fechaNac=" + fechaNac
				+ ", edad=" + edad + ", coloYSenalesParti=" + coloYSenalesParti + ", id_mascota_propietario="
				+ id_mascota_propietario + ", raza_id=" + raza_id + "]";
	}

	

	
}
