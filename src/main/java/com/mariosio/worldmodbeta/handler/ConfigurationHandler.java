package com.mariosio.worldmodbeta.handler;

import com.mariosio.worldmodbeta.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean TestValue = false;

    public static void init(File configFile) {

        // Create the configuration object from the given configuration file
        if (configuration == null) {
            configuration = new Configuration(configFile);
        }
    }

        @SubscribeEvent
        public void onConfigurationChangedEvent (ConfigChangedEvent.OnConfigChangedEvent event){
            if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
                loadConfiguration();
            }
        }

        public void loadConfiguration(){
            TestValue = configuration.getBoolean("Physics (Soon)", Configuration.CATEGORY_GENERAL, false, "Dis iz an example config value");

            if (configuration.hasChanged()){
                configuration.save();
            }
        }

    }
