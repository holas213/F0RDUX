package F0RDUX.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import F0RDUX.api.repositories.UsuarioRepository;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(ApiApplication.class, args);
		UsuarioRepository usuariorepository=context.getBean(UsuarioRepository.class);
	}

}
