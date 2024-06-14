package mx.edu.unsis.loteria.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Loteria API",  // Title
                description = "API to service a mexican lotery.",  // Provide a detailed description
                version = "0.1.0"  // Specify the API version
        )
)
public class OpenApiConfig {


}
