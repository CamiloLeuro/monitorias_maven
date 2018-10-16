/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("/Read.htm")
public class Read {
    @RequestMapping(params = "readVista",method = RequestMethod.POST)
    public String vistasLeer(Model m){
        m.addAttribute("code_inyection","<div class=\"card-body\">\n" +
"              <div class=\"table-responsive\">\n" +
"                <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\n" +
"                  <thead>\n" +
"                    <tr>\n" +
"                      <th>Código</th>\n" +
"                      <th>Nombres</th>\n" +
"                      <th>Apellidos</th>\n" +
"                      <th>Correo</th>\n" +
"                    </tr>\n" +
"                  </thead>\n" +
"                  <tfoot>\n" +
"                    <tr>\n" +
"                      <th>Código</th>\n" +
"                      <th>Nombres</th>\n" +
"                      <th>Apellidos</th>\n" +
"                      <th>Correo</th>\n" +
"                    </tr>\n" +
"                  </tfoot>\n" +
"                  <tbody>\n" +
"                    <tr>\n" +
"                      <td>626514</td>\n" +
"                      <td>Tiger</td>\n" +
"                      <td>Woods</td>\n" +
"                      <td>twords@abc.com</td>\n" +
"                    </tr>\n" +
"                  </tbody>\n" +
"                </table>\n" +
"             <form action=\"Read.htm\" method=\"POST\">" +   
                "             <input type=\"text\" name=\"codigo\" onkeyup=\"myFunction()\" placeholder=\"Código\">"+
"                <button type=\"submit\" class=\"btn btn-primary\" name = \"Consultar\" value=\"Consultar\">Consultar</button>\n" +                
"             </form>"
              + "</div>");
        return "index";
    }
    @RequestMapping(params = "consultar",method = RequestMethod.POST)
    public String consultar(@RequestParam("code") String code, Model m){
        if(code.equals("123")){
            m.addAttribute("name", "Oscar");
            m.addAttribute("surname", "Rolan");
            m.addAttribute("code", "123");
            m.addAttribute("mail", "");
        }else{
            m.addAttribute("messageerr1", "COMPLETE EL CAMPO");
        }
        return "leer";
    }
}
