package com.example.gategame.Move;

public class Move {

    /**
     * @param order order to move to which direction
     * @param location current player location
     * @return Location new location after move
     * @description to move player 1 step to 4 direction based on order
     * @author Zining He
    */
    public static Location move(char order, Location location){
        switch (order){
            case 'W': return location.moveW();
            case 'D': return location.moveD();
            case 'A': return location.moveA();
            default: return location.moveS();
        }
    }


    }



