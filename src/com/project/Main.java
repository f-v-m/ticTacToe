package com.project;


import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        char modeChange;
        System.out.println("Enter 'p' to play with another player");
        modeChange = (char) System.in.read();

        Field field = new Field();
        field.clearConsole();


        Human player1 = new Human();
        System.out.println("Player1: ");
        if (modeChange == 'p'){
            player1.setName();
        }
        else {
            player1.name = "Comp";
        }
        player1.setGameSign("X");
        field.clearConsole();

        Human player2 = new Human();
        System.out.println("Player2: ");
        player2.setName();
        player2.setGameSign("0");
        field.clearConsole();





        field.createField();
        for(;;){

            if (modeChange == 'p'){
                field.inputSign(player1.getGameSign());
            }
            else {
                field.compMoveFirst("X", "0");
            }


            if (field.check(player1.getGameSign())){
                System.out.println(player1.getName() + " WIN!!!!!!");
                break;
            }
            if (field.checkForTie()){
                System.out.println("STANDOFf!!!!!");
                break;
            }




            field.inputSign(player2.getGameSign());
                if (field.check(player2.getGameSign())){
                System.out.println(player2.getName() + " WIN!!!!!!");
                break;
            }

            else {

            }



        }







    }
}