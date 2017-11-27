/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rafaelaznar.bean.specificimplementation;

import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;




public class ViaSpecificBeanImplementation extends TableGenericBeanImplementation  {

    private Integer id;
    private String via;

    public ViaSpecificBeanImplementation() {
    }

    public ViaSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public ViaSpecificBeanImplementation(Integer id, String via) {
        this.id = id;
        this.via = via;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

 
}
