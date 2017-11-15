package co.edu.ucatolica.DTOs;

import java.io.Serializable;
import java.util.Set;

public class Persona implements Serializable {

    private int id = 0;
    private String identificacion = null;
    private String nombre1 = null;
    private String nombre2 = null;
    private String apellido1 = null;
    private String apellido2 = null;
    private String genero = null;
    private String tipoP = null;
    private String fNacimiento = null;
    private String telef = null;
    private String email = null;    
    private Set<Cuenta> Cuenta;
    private Set<Listanegra> Listanegra;
    private Set<Datacredito> Datacredito;
    private Set<EmailCliente> EmailCliente;
    private Set<Solicitud> Solicitud;
    
    public Persona() {
        super();
    }

    public Persona(int id, String identificacion, String nombre1, String nombre2,String apellido1,String apellido2,String genero, String tipoP ,String fNacimiento,String telef ,String email) {
        super();
        this.id = id;
        this.identificacion = identificacion;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.genero = genero;
        this.tipoP = tipoP;
        this.fNacimiento = fNacimiento;
        this.telef = telef;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Set<Cuenta> getCuenta() {
		return Cuenta;
	}

	public void setCuenta(Set<Cuenta> cuenta) {
		Cuenta = cuenta;
	}

	public Set<Listanegra> getListanegra() {
		return Listanegra;
	}

	public void setListanegra(Set<Listanegra> listanegra) {
		Listanegra = listanegra;
	}

	public Set<Datacredito> getDatacredito() {
		return Datacredito;
	}

	public void setDatacredito(Set<Datacredito> datacredito) {
		Datacredito = datacredito;
	}

	public Set<EmailCliente> getEmailCliente() {
		return EmailCliente;
	}

	public void setEmailCliente(Set<EmailCliente> emailCliente) {
		EmailCliente = emailCliente;
	}

	public Set<Solicitud> getSolicitud() {
		return Solicitud;
	}

	public void setSolicitud(Set<Solicitud> solicitud) {
		Solicitud = solicitud;
	}            
}
