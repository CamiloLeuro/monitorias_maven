/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author camilo
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("/Update.htm")
public class Update {
    @RequestMapping(params = "updateVista",method = RequestMethod.POST)
    public String vistasActualizar(Model m){
        m.addAttribute("code_inyection","<form action=\"Update.htm\" method=\"POST\" style=\"padding-left: 20px; padding-right: 20px\";>\n"+
"            <div class=\"form-row\">\n" +
"              <div class=\"form-group col-md-6\">\n" +
"                <label for=\"inputNombres\">Nombres</label>\n" +
"                <input type=\"text\" class=\"form-control\" name=\"inputNombres\" placeholder=\"Nombres\">\n" +
"              </div>\n" +
"              <div class=\"form-group col-md-6\">\n" +
"                <label for=\"inputApellidos\">Apellidos</label>\n" +
"                <input type=\"text\" class=\"form-control\" name=\"inputApellidos\" placeholder=\"Apellidos\">\n" +
"              </div>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"inputEmail\">Correo</label>\n" +
"              <input type=\"email\" class=\"form-control\" name=\"inputEmail\" placeholder=\"Email\">\n" +
"            </div>\n" +
"            <div class=\"form-row\">\n" +
"              <div class=\"form-group col-md-6\">\n" +
"                <label for=\"inputCodigo\">Código</label>\n" +
"                <input type=\"text\" class=\"form-control\" name=\"inputCodigo\" placeholder=\"Código\">\n" +
"              </div>\n" +
"             </div>\n" + 
"             <input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"Código\">"+   
"            <button type=\"submit\" class=\"btn btn-primary\" name = \"consultar\" value=\"consultar\">Consultar</button>\n" +
"            <button type=\"submit\" class=\"btn btn-primary\" name = \"actualizar\" value=\"actualizar\">Actualizar</button>\n" +                
"          </form>");
        return "index";
    }
}
