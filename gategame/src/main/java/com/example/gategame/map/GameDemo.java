package com.example.gategame.map;

import com.example.gategame.control.Location;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal.Signal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.io.IOException;
import java.util.Map;
import java.io.IOException;

import java.io.InputStream;
public class GameDemo {
    public static void main(String[] args) {
        //just for test, it can be changed to Utility class later
        String[] mapData = {
                "####.####",
                "#...#...#",
                "#.#...#.#",
                "#.#####.#",
                "#.......#",
                "#########"
        };

        GameMap gameMap = new GameMap(mapData);
        Location playerLocation = new Location(1, 1);
        //display the location of player
        if (gameMap.isValidMove(playerLocation)) {
            gameMap.displayMap(playerLocation);
        } else {
            System.out.println("Invalid!");
        }

    }
}




