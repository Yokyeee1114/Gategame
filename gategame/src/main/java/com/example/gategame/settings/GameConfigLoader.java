package com.example.gategame.settings;

import com.example.gategame.GameEngine;
import com.example.gategame.backpack.Inventory;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Hao Ye(u7981083)
 */
public class GameConfigLoader {

    public static final String GAME_ENGINE_PATH = "settings.json";
    public static SettingsConfig config;

    public static void loadConfig() {
        ClassLoader classLoader = GameEngine.class.getClassLoader();
        Gson gson = new Gson();
        try (InputStream inputStream = classLoader.getResourceAsStream(GAME_ENGINE_PATH)) {
            config = gson.fromJson(new BufferedReader(new InputStreamReader(inputStream)), SettingsConfig.class);
            config.getInventoryConfig().initializeInventory(); // config the inventory
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
