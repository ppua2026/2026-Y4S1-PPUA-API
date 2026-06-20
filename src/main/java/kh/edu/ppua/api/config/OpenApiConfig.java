package kh.edu.ppua.api.config;

import io.swagger.v3.oas.models.PathItem;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi strictApi() {

        return GroupedOpenApi.builder()
                .group("default")
                .packagesToScan("kh.edu.ppua.api.controller")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    Class<?> beanType = handlerMethod.getBeanType();
                    if (!beanType.isAnnotationPresent(RestController.class)) {
                        // Return null or skip operations from non-RestControllers
                        return null;
                    }
                    return operation;
                })
                .build();
    }

    @Bean
    public OpenApiCustomizer filterHttpMethodsCustomizer() {
        // Define the allowed HTTP methods
        Set<PathItem.HttpMethod> allowedMethods = Set.of(
                PathItem.HttpMethod.GET,
                PathItem.HttpMethod.POST,
                PathItem.HttpMethod.PUT,
                PathItem.HttpMethod.DELETE
        );

        return openApi -> openApi.getPaths().values().forEach(pathItem -> {
            // Remove any operation that is not in our allowed set (e.g., PATCH, HEAD, OPTIONS)
            pathItem.readOperationsMap().keySet().forEach(method -> {
                if (!allowedMethods.contains(method)) {
                    setNullOperation(pathItem, method);
                }
            });
        });
    }

    private void setNullOperation(PathItem pathItem, PathItem.HttpMethod method) {
        switch (method) {
            case PATCH -> pathItem.setPatch(null);
            case HEAD -> pathItem.setHead(null);
            case OPTIONS -> pathItem.setOptions(null);
            case TRACE -> pathItem.setTrace(null);
        }
    }

}
