package bg.uni.sofia.fmi.spring.hirebean;

import bg.uni.sofia.fmi.spring.hirebean.repository.SoftDeleteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = SoftDeleteRepository.class)
public class HirebeanBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(HirebeanBackendApplication.class, args);
  }
}
