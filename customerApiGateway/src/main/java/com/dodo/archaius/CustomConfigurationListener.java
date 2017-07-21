package com.dodo.archaius;

import org.apache.commons.configuration.event.ConfigurationListener;

import org.apache.commons.configuration.event.ConfigurationEvent;

public class CustomConfigurationListener implements ConfigurationListener {
	public void configurationChanged(ConfigurationEvent event) {
		if (!event.isBeforeUpdate()) {
			// only display events after the modification was done
			System.out.println("Received event!");
			System.out.println("Type = " + event.getType());
			if (event.getPropertyName() != null) {
				System.out.println("Property name = " + event.getPropertyName());
			}
			if (event.getPropertyValue() != null) {
				System.out.println("Property value = " + event.getPropertyValue());
			}
		}
	}
}
