
package modelo;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author camilo
 */
public class Conectar {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://sql10.freemysqlhosting.net/sql10261706");
        datasource.setUsername("sql10261706");
        datasource.setPassword("6VBuTYR4hC");
        
        return datasource;
    }
}

