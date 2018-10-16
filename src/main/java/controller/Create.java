/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import modelo.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.util.Length;
/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("/Create.htm")
public class Create {
    
    private JdbcTemplate jdbcTemplate;

    public Create() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    
    
    @RequestMapping(params = "createVista",method = RequestMethod.POST)
    public String vistasCrear(Model m){
        String html_inyec = "<form action=\"Create.htm\" method=\"POST\" style=\"padding-left: 20px; padding-right: 20px\";>\n"+
                "              <div class=\"form-group col-md-6\">\n" +
                "                <label for=\"inputNombres\">NÚMERO DE CARNET</label>\n" +
                "                <input type=\"number\" class=\"form-control\" name=\"inputCarnet\" placeholder=\"code\">\n" +
                "              </div>\n" +
                "              <div class=\"form-group col-md-6\">\n" +
                "                <label for=\"inputApellidos\">CONTRASEÑA</label>\n" +
                "                <input type=\"password\" class=\"form-control\" name=\"inputPass\" placeholder=\"password\">\n" +
                "              </div>\n" +
                "            <div class=\"form-group col-md-6\">\n" +
                "            <select name = \"inputCodeCourse\">\n"+
                "                 <option value= 0> Seleccione curso</option>\n";
        List<Map<String, Object>> cursos = jdbcTemplate.queryForList("SELECT idcursos, nombre_curso FROM monitorias.cursos\n" +
                                              "WHERE estado_curso = 1 and (monitor is null or monitor = 0);");
        for(int i = 0; i < cursos.size();i++){
            html_inyec = html_inyec + "       <option value="+cursos.get(i).get("idcursos").toString()+">"+cursos.get(i).get("nombre_curso").toString()+"</option>\n";
        }
        html_inyec+="            </select>"+
                "            </div>\n" +
                "            <button type=\"submit\" class=\"btn btn-primary\" name = \"registrar\" value=\"Registrar\">Registrar</button>\n" +
                "          </form>";
        m.addAttribute("code_inyection",html_inyec);
            return "index";
    }
    @RequestMapping(params = "registrar",method = RequestMethod.POST)
    public String registrar(@RequestParam("inputCarnet") String codeCarnet, @RequestParam("inputPass") String pass,///
        @RequestParam("inputCodeCourse") String codeCourse, Model m){
        System.out.println(codeCourse);
        if(!codeCarnet.equals("") && !pass.equals("") && !codeCourse.equals("")){
            if (validacion_usuario(codeCarnet,pass)){
                String verificacion_curso = validacion_curso(codeCarnet,codeCourse);
                if (verificacion_curso.equals("cumple")){
                    m.addAttribute("code_error", "REGISTRADO EN CURSO");
                    vistasCrear(m);
                }else{
                    m.addAttribute("code_error", verificacion_curso);
                    vistasCrear(m);
                }
            }else{
                m.addAttribute("code_error", "PASSWORD INCORRECTO");
                vistasCrear(m);
            }
        }else if(codeCarnet.equals("") || pass.equals("") || codeCourse.equals("")){
            m.addAttribute("code_error", "COMPLETE TODOS LOS CAMPOS");
            vistasCrear(m);
        }
        return "index";
    }
    public String cursos_disponibles(){
        List cursos = jdbcTemplate.queryForList("SELECT idcursos, nombre_curso FROM monitorias.cursos\n" +
                                              "WHERE estado_curso = 1 and (monitor is null or monitor = 0)");
        System.out.println(cursos);
        return "";
    }
    
    public boolean validacion_usuario(String codeCarnet, String pass){
        String sql_query = "SELECT count(1) as verificacion\n " +
                            "FROM monitorias.users_ldap u\n " +
                            "INNER JOIN monitorias.persona p on p.idpersona = u.id_persona\n " +
                            "WHERE u.contraseña = '"+pass+"'\n "+
                            "AND p.codigo_carnet = "+codeCarnet+";";
        Map validar = jdbcTemplate.queryForMap(sql_query);
        if(validar.get("verificacion").toString().equals("1")){
            return true;
        }else{
            return false;
        }
    }
    
    public String validacion_curso(String codeCarnet,String codeCourse){
        Map validar_curso = jdbcTemplate.queryForMap("SELECT if(monitor is null,\"si\",\"no\") as ver \n" +
                                                    "FROM monitorias.cursos \n" +
                                                    "where idcursos="+codeCourse+";");
        if(validar_curso.get("ver").toString().equals("si")){
            Map validar = jdbcTemplate.queryForMap("SELECT p.promedio, p.creditos, p.tipo_pre_pos, if(ct.idcursos is null,'no','si') as ver\n " +
                                                    "FROM monitorias.persona p\n " +
                                                    "LEFT JOIN monitorias.cursos_tomados ct on ct.idpersona =p.idpersona\n " +
                                                    "WHERE p.codigo_carnet = "+codeCarnet);
            if (validar.get("ver").equals("si")){
                if (validar.get("tipo_pre_pos").toString().equals("pregrado")){
                    if (Float.parseFloat(validar.get("promedio").toString())>3.8){
                        if (Integer.parseInt(validar.get("creditos").toString())>=22){
                            return "cumple";
                        }else{
                            return "NO CUMPLE CON LOS CREDITOS NECESARIOS SUS CREDITOS="+validar.get("creditos").toString()+" CREDITOS REQUERIDOS MAS DE 21";
                        }
                    }else{
                        if (Integer.parseInt(validar.get("creditos").toString())>=22){
                            return "NO CUMPLE CON EL PROMEDIO PARA SER TUTOR SU PROMEDIO="+validar.get("promedio").toString()+" PROMEDIO REQUERIDO MAS DE 3.8";
                        }else{
                            return "NO CUMPLE CON LOS CREDITOS NECESARIOS SUS CREDITOS="+validar.get("creditos").toString()+" CREDITOS REQUERIDOS MAS DE 21, Y "+
                                   "NO CUMPLE CON EL PROMEDIO PARA SER TUTOR SU PROMEDIO="+validar.get("promedio").toString()+" PROMEDIO REQUERIDO MAS DE 3.8";
                        }
                    }
                }else{
                    if (Float.parseFloat(validar.get("promedio").toString())>4.2){
                        Map validar2 = jdbcTemplate.queryForMap("SELECT count(1) as validar\n " +
                                                    "FROM monitorias.persona p\n " +
                                                    "INNER JOIN monitorias.cursos c on c.monitor = p.idpersona\n " +
                                                    "WHERE p.codigo_carnet = "+codeCarnet);
                        if (validar2.get("validar").toString().equals("0")){
                            return "cumple";
                        }else{
                            return "NO PUEDE TENER MAS DE UNA MONITORIA ASIGNADA";
                        }                                          
                    }else{
                        return "NO CUMPLE CON EL PROMEDIO PARA SER TUTOR SU PROMEDIO="+validar.get("promedio").toString()+" PROMEDIO REQUERIDO MAS DE 4.2";
                    }
                }
            }else{
                return "DEBE HABER VISTO EL CURSO ANTES DE SER TUTOR DEL MISMO";
            }
        }else{
            return "CURSO NO DISPONIBLE";
        }
    }
}
