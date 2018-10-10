package diaz.ignacio.authenticationservice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig
{
    private static final Contact CONTACT = new Contact("Ignacio Diaz", "https://www.linkedin.com/in/ignacio-d%C3%ADaz-73733098/", "ignaciodiazmaurino@gmail.com");

    private static final Set <String> CONSUMES = new HashSet <>(Arrays.asList("application/json"));
    private static final String DESCRIPTION = "";
    private static final String TITLE = "Authentication Service";
    private static final Set <String> PRODUCES = new HashSet <>(Arrays.asList("application/json"));
    private static final String VERSION;

    static
    {
        VERSION = "1.0";
    }

    private ModelRef modelRef = new ModelRef("RestApiExceptionModel");
    private List <ResponseMessage> responseMessages = Arrays.asList(
        new ResponseMessageBuilder().code(401).message("Unauthorized").responseModel(modelRef).build(),
        new ResponseMessageBuilder().code(400).message("NotFound").responseModel(modelRef).build(),
        new ResponseMessageBuilder().code(500).message("InternalServerError").responseModel(modelRef).build()
    );

    @Bean
    public Docket apiDefinition()
    {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.POST, responseMessages)
            .apiInfo(getApiInfo())
            .consumes(CONSUMES)
            .produces(PRODUCES);
    }


    private ApiInfo getApiInfo()
    {
        return new ApiInfoBuilder()
            .contact(CONTACT)
            .description(DESCRIPTION)
            .title(TITLE)
            .version(VERSION)
            .build();
    }
}
