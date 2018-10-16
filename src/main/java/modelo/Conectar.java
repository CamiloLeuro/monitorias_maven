
package modelo;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author camilo
 */
public class Conectar {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost/monitorias");
        datasource.setUsername("root");
        datasource.setPassword("root");
        
        return datasource;
    }
}
