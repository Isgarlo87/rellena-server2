/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.bean.specificimplementation;


import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import java.util.Date;


public class PacienteSpecificBeanImplementation extends TableGenericBeanImplementation {

    private Integer id;
    private String dni;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String direccion;
    private String ciudad;
    private String codigo_postal;
    private String provincia;
    private String pais;
    private String email;
    private String telefono1;
    private String telefono2;
    private String nombre_padre;
    private String nombre_madre;
    private Date fecha_nacimiento;
    private String ciudad_nacimiento;
    private String pais_nacimiento;
    private String sip_aseguradora;
    private Integer id_tipopago;
    private Integer id_sexo;
    private Integer id_usuario;

    public PacienteSpecificBeanImplementation() {
    }

    public PacienteSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public PacienteSpecificBeanImplementation(Integer id, int idTipopago, int idSexo, int idUsuario) {
        this.id = id;
        this.id_tipopago = idTipopago;
        this.id_sexo = idSexo;
        this.id_usuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primer_apellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primer_apellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundo_apellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundo_apellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigo_postal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigo_postal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getNombrePadre() {
        return nombre_padre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombre_padre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombre_madre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombre_madre = nombreMadre;
    }

    public Date getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fecha_nacimiento = fechaNacimiento;
    }

    public String getCiudadNacimiento() {
        return ciudad_nacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudad_nacimiento = ciudadNacimiento;
    }

    public String getPaisNacimiento() {
        return pais_nacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.pais_nacimiento = paisNacimiento;
    }

    public String getSipAseguradora() {
        return sip_aseguradora;
    }

    public void setSipAseguradora(String sipAseguradora) {
        this.sip_aseguradora = sipAseguradora;
    }

    public int getIdTipopago() {
        return id_tipopago;
    }

    public void setIdTipopago(int idTipopago) {
        this.id_tipopago = idTipopago;
    }

    public int getIdSexo() {
        return id_sexo;
    }

    public void setIdSexo(int idSexo) {
        this.id_sexo = idSexo;
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.id_usuario = idUsuario;
    }


  
    
}
