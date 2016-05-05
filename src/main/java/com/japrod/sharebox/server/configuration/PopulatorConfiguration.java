package com.japrod.sharebox.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
class PopulatorConfiguration {

  @Bean
  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {

    Resource sourceData = new ClassPathResource("fixtures.json");

    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
    factory.setResources(new Resource[] { sourceData });
    return factory;
  }
}