import dao.PersonRepository;
import domain.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Iwan on 03.04.2016
 */

@SpringBootApplication
@ComponentScan({"config", "controller", "dao"})
@EnableJpaRepositories("dao")
@EntityScan("domain")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Bean
    public CommandLineRunner demo(PersonRepository repository) {
        return (args) -> {
            repository.save(new Person("Jack"));
            repository.save(new Person("Chloe"));
            repository.save(new Person("Kim"));
            repository.save(new Person("David"));
            repository.save(new Person("Michelle"));
        };
    }
}
