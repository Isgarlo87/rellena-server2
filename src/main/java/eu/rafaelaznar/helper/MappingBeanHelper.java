/*
 * Copyright (c) 2017 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * trolleyes-server: Helps you to develop easily AJAX web applications 
 *               by copying and modifying this Java Server.
 *
 * Sources at https://github.com/rafaelaznar/trolleyes-server
 * 
 * trolleyes-server is distributed under the MIT License (MIT)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.rafaelaznar.helper;

import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.publicinterface.GenericBeanInterface;
import eu.rafaelaznar.bean.specificimplementation.ApellidoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ComunidadSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.MunicipioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombrefemeninoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombremasculinoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.PacienteSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ProvinciaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ViaSpecificBeanImplementation;

/**
 *
 * @author raznara
 */
public class MappingBeanHelper {

    public static GenericBeanInterface getBean(String ob) {
        GenericBeanInterface oBean = null;

        switch (ob) {
            case "usuario":
                oBean = new UsuarioSpecificBeanImplementation();
                break;
            case "tipousuario":
                oBean = new TipousuarioSpecificBeanImplementation();
                break;
          
            case "apellido":
                oBean =  new ApellidoSpecificBeanImplementation();
                break;
            case "comunidad":
                oBean = new ComunidadSpecificBeanImplementation();
                break;
            case "municipio":
                oBean = new MunicipioSpecificBeanImplementation();
                break;
            case "nombrefemenino":
                oBean = new NombrefemeninoSpecificBeanImplementation();
                break;
            case "nombremasculino":
                oBean = new NombremasculinoSpecificBeanImplementation();
                break;
            case "paciente":
                oBean = new PacienteSpecificBeanImplementation();
                break;
            case "provincia":
                oBean = new ProvinciaSpecificBeanImplementation();
                break;
            case "via":
                oBean = new ViaSpecificBeanImplementation();
                break;
            default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oBean;
    }
}
