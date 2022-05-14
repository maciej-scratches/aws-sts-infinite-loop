package com.example;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            // run with env variable AWS_ROLE_ARN=arn:aws:iam::xaxsaxsadsa:role/databricks_nss
            AWSSecretsManager build = AWSSecretsManagerClientBuilder.standard().withRegion("eu-west-1").build();
            GetSecretValueResult foo = build.getSecretValue(new GetSecretValueRequest().withSecretId("foo"));
            System.out.println(foo.getSecretString());
        };
    }
}
