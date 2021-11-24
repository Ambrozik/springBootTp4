package ul.fr.tp4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Tp4Application {

    @Autowired
    private JdbcTemplate jdbcTemplate ;
    public static void main(String[] args) {
        SpringApplication.run(Tp4Application.class, args);
    }

    @PostConstruct
    private void initDb(){
        String sqlStatements[] ={
                "INSERT INTO HERO(name,faction,power,hp) VALUES ('coco', 'human','fire', 10)",
                "INSERT INTO HERO(name,faction,power,hp) VALUES ('ziak', 'raptor','water', 20)"
        };
        Arrays.asList(sqlStatements).forEach(sql -> {
            jdbcTemplate.execute(sql);
        });
    }

}
