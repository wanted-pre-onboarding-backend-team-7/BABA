package org.example.baba.common.property;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.util.StringUtils;

public class YamlPropertySourceFactory implements PropertySourceFactory {
  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource resource)
      throws IOException {
    Properties yamlProperties = loadYamlProperties(resource);
    String sourceName = StringUtils.hasText(name) ? name : resource.getResource().getFilename();
    return new PropertiesPropertySource(
        Objects.requireNonNull(sourceName), Objects.requireNonNull(yamlProperties));
  }

  private Properties loadYamlProperties(EncodedResource resource) {
    YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
    factory.setResources(resource.getResource());
    return factory.getObject();
  }
}
