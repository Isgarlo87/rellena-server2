/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.bean.specificimplementation;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;





public class MunicipioSpecificBeanImplementation extends TableGenericBeanImplementation  {

 
    private Integer id;
    private Integer id_comunidad;
    private Integer id_provincia;
    private String nombre;

    public MunicipioSpecificBeanImplementation() {
    }

    public MunicipioSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdComunidad() {
        return id_comunidad;
    }

    public void setIdComunidad(Integer idComunidad) {
        this.id_comunidad = idComunidad;
    }

    public Integer getIdProvincia() {
        return id_provincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.id_provincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
}
