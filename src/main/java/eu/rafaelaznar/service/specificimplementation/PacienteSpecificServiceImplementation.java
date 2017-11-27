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
package eu.rafaelaznar.service.specificimplementation;

import eu.rafaelaznar.bean.ReplyBean;
import eu.rafaelaznar.bean.specificimplementation.ApellidoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.MunicipioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombrefemeninoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombremasculinoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.PacienteSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ProvinciaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ViaSpecificBeanImplementation;
import eu.rafaelaznar.connection.ConnectionInterface;
import eu.rafaelaznar.dao.specificimplementation.ApellidoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.MunicipioSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.NombrefemeninoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.NombremasculinoSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.PacienteSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.ProvinciaSpecificDaoImplementation;
import eu.rafaelaznar.dao.specificimplementation.ViaSpecificDaoImplementation;
import eu.rafaelaznar.helper.AppConfigurationHelper;
import eu.rafaelaznar.helper.EncodingUtilHelper;
import eu.rafaelaznar.helper.Log4jConfigurationHelper;
import eu.rafaelaznar.service.genericimplementation.GenericTableService;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class PacienteSpecificServiceImplementation extends GenericTableService {

    public PacienteSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    @Override
    protected Boolean checkPermission(String strMethodName) {
        return true;
    }

    public ReplyBean vacia() throws Exception {
        if (this.checkPermission("vacia")) {
            ob = "paciente";
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBean oReplyBean = null;
            try {
                oPooledConnection = AppConfigurationHelper.getSourceConnection();
                oConnection = oPooledConnection.newConnection();
                PacienteSpecificDaoImplementation oDao = new PacienteSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                Integer resultado = oDao.vacia();

                oReplyBean = new ReplyBean(200, "OK");

            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jConfigurationHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }

            return oReplyBean;
        } else {
            return new ReplyBean(401, EncodingUtilHelper.quotate("Unauthorized"));
        }
    }

    public ReplyBean rellena() throws Exception {
        if (this.checkPermission("rellena")) {
            ob = "paciente";
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBean oReplyBean = null;
            Integer num = Integer.parseInt(oRequest.getParameter("num"));
            int result = 0;
            try {
                oPooledConnection = AppConfigurationHelper.getSourceConnection();
                oConnection = oPooledConnection.newConnection();
                PacienteSpecificDaoImplementation oPacienteDao = new PacienteSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);

                PacienteSpecificBeanImplementation oPacienteBean = new PacienteSpecificBeanImplementation();

                for (int j = 1; j <= num; j++) {

                    String dni = "0";
                    for (int i = 1; i <= 10; i++) {
                        dni += AppConfigurationHelper.getRandomInt(0, 8);
                    }
                    dni += AppConfigurationHelper.getRadomChar();
                    oPacienteBean.setDni(dni);

                    int sexo = (int) AppConfigurationHelper.getRandomInt(0, 1);
                    //-- Nombre
                    if (sexo == 0) {
                        NombremasculinoSpecificBeanImplementation oNombremasculinoBean = new NombremasculinoSpecificBeanImplementation();
                        NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                        oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oDaoMasculino.get((int) AppConfigurationHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                        oPacienteBean.setNombre(oNombremasculinoBean.getNombre());
                    } else {
                        NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = new NombrefemeninoSpecificBeanImplementation();
                        NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                        oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oDaoFemenino.get((int) AppConfigurationHelper.getRandomInt(1, oDaoFemenino.getCount(null).intValue()), 0);
                        oPacienteBean.setNombre(oNombrefemeninoBean.getNombre());
                    }
                    //--- Apellido 1
                    ApellidoSpecificBeanImplementation oApellidoBean = new ApellidoSpecificBeanImplementation();
                    ApellidoSpecificDaoImplementation oDaoApellido = new ApellidoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oApellidoBean = (ApellidoSpecificBeanImplementation) oDaoApellido.get((int) AppConfigurationHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                    oPacienteBean.setPrimerApellido(oApellidoBean.getApellido());
                    //--- Apellido 2
                    oApellidoBean = new ApellidoSpecificBeanImplementation();
                    oDaoApellido = new ApellidoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oApellidoBean = (ApellidoSpecificBeanImplementation) oDaoApellido.get((int) AppConfigurationHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                    oPacienteBean.setSegundoApellido(oApellidoBean.getApellido());
                    //--- Dirección
                    String Direccion = "";
                    ViaSpecificBeanImplementation oViaBean = new ViaSpecificBeanImplementation();
                    ViaSpecificDaoImplementation oDaoVia = new ViaSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oViaBean = (ViaSpecificBeanImplementation) oDaoVia.get((int) AppConfigurationHelper.getRandomInt(1, oDaoVia.getCount(null).intValue()), 0);
                    //--
                    sexo = (int) AppConfigurationHelper.getRandomInt(0, 1);
                    //--
                    String nombre = "";
                    if (sexo == 0) {
                        NombremasculinoSpecificBeanImplementation oNombremasculinoBean = new NombremasculinoSpecificBeanImplementation();
                        NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                        oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oDaoMasculino.get((int) AppConfigurationHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                        nombre = oNombremasculinoBean.getNombre();
                    } else {
                        NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = new NombrefemeninoSpecificBeanImplementation();
                        NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                        oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oDaoFemenino.get((int) AppConfigurationHelper.getRandomInt(0, oDaoFemenino.getCount(null).intValue()), 0);
                        nombre = oNombrefemeninoBean.getNombre();
                    }
                    oApellidoBean = new ApellidoSpecificBeanImplementation();
                    oDaoApellido = new ApellidoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oApellidoBean = (ApellidoSpecificBeanImplementation) oDaoApellido.get((int) AppConfigurationHelper.getRandomInt(1, oDaoApellido.getCount(null).intValue()), 0);
                    String ap = oApellidoBean.getApellido();
                    //---
                    Direccion = oViaBean.getVia() + " de " + nombre + " " + ap;
                    oPacienteBean.setDireccion(Direccion);
                    //-- Ciudad
                    MunicipioSpecificBeanImplementation oMunicipioBean = new MunicipioSpecificBeanImplementation();
                    MunicipioSpecificDaoImplementation oDaoMunicipio = new MunicipioSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oMunicipioBean = (MunicipioSpecificBeanImplementation) oDaoMunicipio.get((int) AppConfigurationHelper.getRandomInt(1, oDaoMunicipio.getCount(null).intValue()), 0);
                    oPacienteBean.setCiudad(oMunicipioBean.getNombre());
                    //-- codigo postal
                    String cod_postal = "46" + AppConfigurationHelper.getRandomInt(0, 9) + AppConfigurationHelper.getRandomInt(0, 1) + AppConfigurationHelper.getRandomInt(0, 9);
                    oPacienteBean.setCodigoPostal(cod_postal);
                    //--- provincia
                    ProvinciaSpecificDaoImplementation oDaoProvincia = new ProvinciaSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    ProvinciaSpecificBeanImplementation oProvinciaBean = new ProvinciaSpecificBeanImplementation();
                    oProvinciaBean = (ProvinciaSpecificBeanImplementation) oDaoProvincia.get(oMunicipioBean.getIdProvincia(), 0);
                    oPacienteBean.setProvincia(oProvinciaBean.getProvincia());
                    //--- país
                    oPacienteBean.setPais("España");
                    //--- email
                    String nombrep = oPacienteBean.getNombre();
                    String primerp = oPacienteBean.getPrimerApellido();
                    String segundop = oPacienteBean.getSegundoApellido();
                    String nombrep2c = nombrep.substring(0, Math.min(nombrep.length(), 2));
                    String primerp2c = primerp.substring(0, Math.min(primerp.length(), 2));
                    String segundop2c = segundop.substring(0, Math.min(segundop.length(), 2));
                    String mail = nombrep2c + primerp2c + segundop2c + "@" + oPacienteBean.getPrimerApellido() + ".es";
                    oPacienteBean.setEmail(mail);
                    ///--- telefono1
                    if (AppConfigurationHelper.getRandomInt(0, 1) == 0) {
                        oPacienteBean.setTelefono1(Integer.toString(AppConfigurationHelper.getRandomInt(620000000, 629999999)));
                    } else {
                        oPacienteBean.setTelefono1(Integer.toString(AppConfigurationHelper.getRandomInt(640000000, 649999999)));
                    }
                    //---- telefono 2
                    if (AppConfigurationHelper.getRandomInt(0, 1) == 0) {
                        oPacienteBean.setTelefono2(Integer.toString(AppConfigurationHelper.getRandomInt(620000000, 629999999)));
                    } else {
                        oPacienteBean.setTelefono2(Integer.toString(AppConfigurationHelper.getRandomInt(640000000, 649999999)));
                    }
                    //----- Nombre del padre
                    NombremasculinoSpecificBeanImplementation oNombremasculinoBean = new NombremasculinoSpecificBeanImplementation();
                    NombremasculinoSpecificDaoImplementation oDaoMasculino = new NombremasculinoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oNombremasculinoBean = (NombremasculinoSpecificBeanImplementation) oDaoMasculino.get((int) AppConfigurationHelper.getRandomInt(1, oDaoMasculino.getCount(null).intValue()), 0);
                    nombre = oNombremasculinoBean.getNombre();
                    oPacienteBean.setNombrePadre(nombre);
                    //---- Nombre de la madre
                    NombrefemeninoSpecificBeanImplementation oNombrefemeninoBean = new NombrefemeninoSpecificBeanImplementation();
                    NombrefemeninoSpecificDaoImplementation oDaoFemenino = new NombrefemeninoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oNombrefemeninoBean = (NombrefemeninoSpecificBeanImplementation) oDaoFemenino.get((int) AppConfigurationHelper.getRandomInt(0, oDaoFemenino.getCount(null).intValue()), 0);
                    nombre = oNombrefemeninoBean.getNombre();
                    oPacienteBean.setNombrePadre(nombre);
                    //---- fecha_nacimiento
                    Date fnac = AppConfigurationHelper.getRadomDate();
                    oPacienteBean.setFechaNacimiento(fnac);
                    //---
                    oMunicipioBean = new MunicipioSpecificBeanImplementation();
                    oDaoMunicipio = new MunicipioSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oMunicipioBean = (MunicipioSpecificBeanImplementation) oDaoMunicipio.get((int) AppConfigurationHelper.getRandomInt(1, oDaoMunicipio.getCount(null).intValue()), 0);
                    oPacienteBean.setCiudadNacimiento(oMunicipioBean.getNombre());
                    //---
                    //--- país
                    oPacienteBean.setPaisNacimiento("España");
                    //--sip
                    String sip = "0";
                    for (int i = 1; i <= 10; i++) {
                        sip += AppConfigurationHelper.getRandomInt(0, 9);
                    }
                    oPacienteBean.setSipAseguradora(sip);
                    //--
                    oPacienteBean.setIdTipopago(AppConfigurationHelper.getRandomInt(1, 9));
                    oPacienteBean.setIdSexo(sexo);
                    oPacienteBean.setIdUsuario(1);

                    result += oPacienteDao.set(oPacienteBean);
                }

                oReplyBean = new ReplyBean(200, Integer.toString(result));
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jConfigurationHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }

            return oReplyBean;
        } else {
            return new ReplyBean(401, EncodingUtilHelper.quotate("Unauthorized"));
        }
    }

    public ReplyBean cuenta() throws Exception {
        if (this.checkPermission("cuenta")) {
            ob = "paciente";
            return this.getCount();
        } else {
            return new ReplyBean(401, EncodingUtilHelper.quotate("Unauthorized"));
        }
    }

}
