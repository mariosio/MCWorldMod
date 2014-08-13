package com.mariosio.worldmodbeta.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static void init(File configFile){

        // Create the configuration object from the given configuration file
        Configuration configuration = new Configuration(configFile);
        boolean configValue = false;
        try
        {

            // Load the config file
            configuration.load();

            // Read in properties in config file
            configValue = configuration.get("Physics (Soon)", "Block Physics", true, "Example ConfigValue").getBoolean(true);
        }

        catch (Exception e)
        {
            // Log Exception
        }

        finally
        {
            // Save the config file
            configuration.hasChanged();
            configuration.save();
        }

        System.out.println("Configuration Test: " + configValue);
    }
}
