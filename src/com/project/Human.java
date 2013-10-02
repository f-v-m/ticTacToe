package com.project;


import java.util.Scanner;

public class Human {
    private static final int MIN_NAME_LENGTH = 3;

    private String name;
    private String gameSign;
    Scanner scan = new Scanner(System.in);

    public void setName() {
        System.out.println("Input player name: ");
        name = scan.nextLine();
    }
    public String getName(){
        return name;
    }

    public void setGameSign(String sign){
        gameSign = sign;
    }
    public String getGameSign(){
        return gameSign;
    }
//HELLO

}
