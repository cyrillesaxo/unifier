package com.dodo.archaius;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.PropertySource;
 
import java.io.IOException;
 
public class SpringArchaiusPropertySource extends PropertySource<Void> {
 
 
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringArchaiusPropertySource.class);
 
 
    public SpringArchaiusPropertySource(String name) {
        super(name);
        try {
            ConfigurationManager
                    .loadCascadedPropertiesFromResources(name);
        } catch (IOException e) {
            LOGGER.warn(
                    "Cannot find the properties specified : {}", name);
        }
 
    }
 
    @Override
    public Object getProperty(String name) {
         return DynamicPropertyFactory.getInstance().getStringProperty(name, null).get();
    }
}