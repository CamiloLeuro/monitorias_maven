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
@RequestMapping("/Inicio.htm")
public class Inicio {
    @RequestMapping(params = "init",method = RequestMethod.POST)
    public String inicio(@RequestParam("init") String code, Model m){
        if(code.equals("")){
            m.addAttribute("var", "1");
            m.addAttribute("code_inyection", "<h3>FORMA PARTE DE NUESTRAS MONITORIAS ESTUDIANTILES</h3>\n" +
    "          <img src=\"https://orientacion.universia.net.co/imgs2011/imagenes/fachada_se-2017_06_05_143618.jpg\" style=\"width:1000px;height:600px;\"/>");
            return "index";
        }else if(code.equals("1")){
            m.addAttribute("var", "2");
            m.addAttribute("code_inyection", "<h3>FORMA PARTE DE NUESTRAS MONITORIAS ESTUDIANTILES</h3>\n" +
    "          <img src=\"https://images.paginasamarillas.com/15417625/429006/animation/4.jpg\" style=\"width:1000px;height:600px;\"/>");
            return "index";
        }else{
            m.addAttribute("var", "");
            m.addAttribute("code_inyection", "");
            return "index";
        }
    }
}
