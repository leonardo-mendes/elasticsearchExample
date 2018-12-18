import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = {"repositories"})
@EntityScan(basePackages = {"domains"})
@ComponentScan(basePackages = {"resources", "services", "configurations"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}