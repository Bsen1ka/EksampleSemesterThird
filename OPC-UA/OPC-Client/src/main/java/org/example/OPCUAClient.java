package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class OPCUAClient {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OPCUAClient.class, args);

        // Get OPCUAService bean from the context
        OPCUAService opcuaService = context.getBean(OPCUAService.class);

        // Perform the operation to read and save node value
        opcuaService.readAndSaveNodeValue();
    }
}
