package com.project;


import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Field field = new Field();
        field.clearConsole();
        Human player1 = new Human();
        Human player2 = new Human();
        System.out.println("Player1: ");
        player1.setName();
        player1.setGameSign("X");
        field.clearConsole();

        System.out.println("Player2: ");
        player2.setName();
        player2.setGameSign("0");
        field.clearConsole();


        field.createField();
        for(;;){
            field.inputSign(player1.getGameSign());
            if (field.check(player1.getGameSign())){
                System.out.println(player1.getName() + " WIN!!!!!!");
                break;
            }
            if (field.checkForTie()){
                System.out.println("TIE!!!!!");
                break;
            }

            field.inputSign(player2.getGameSign());
            if (field.check(player2.getGameSign())){
                System.out.println(player2.getName() + " WIN!!!!!!");
                break;
            }

        }





    }
}