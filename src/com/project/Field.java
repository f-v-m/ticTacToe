package com.project;

import java.io.IOException;
import java.io.Console;
import java.util.Scanner;

public class Field {
    private static final int FIELD_SIZE = 3;
    private static final int COORDINATE_NUMBER = 2;

    private String[][] field = new String[FIELD_SIZE][FIELD_SIZE];
    public int[] emptyCoordinate = new int[COORDINATE_NUMBER];
    private int[] coordinates = new int[COORDINATE_NUMBER];


    public void changeCell(String sign, int coordinate1, int coordinate2){
        field[coordinate1][coordinate2] = sign;
    }

    public void inputSign(String sign) throws IOException {
        clearConsole();

        Scanner scan = new Scanner(System.in);
        System.out.println("Your sign: " + sign);
        System.out.println("Input coordinate 'x':");
        showField();
        coordinates[0] = scan.nextInt() - 1;
        clearConsole();
        System.out.println("Your sign: " + sign);
        System.out.println("Input coordinate 'y':");
        showField();
        coordinates[1] = scan.nextInt() - 1;
        if(field[coordinates[0]][coordinates[1]] != " "){
            System.out.println("Try again:)");
            System.in.read();
            inputSign(sign);
        }

        clearConsole();
        changeCell(sign, coordinates[0], coordinates[1]);
        showField();
    }


    public void clearConsole(){
        System.out.println("\u001b[2J");
    }

    public void createField(){
        for(int i = 0; i < FIELD_SIZE; i++){
            for(int j = 0; j < FIELD_SIZE; j++){
                field[i][j] = " ";
            }
        }
    }

    public void showField(){
        System.out.println("");
        System.out.println("   1  2  3 ");
        System.out.println(" ----------");
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++){
                if (j == 0){
                    System.out.print((i+1) + "|[" + field[i][j] + "]");
                }
                else {
                    System.out.print("[" + field[i][j] + "]");
                }

            }
            System.out.println("");
        }

    }


    public boolean checkHor(String sign){
        boolean check, a;
        for(int i = 0; i < FIELD_SIZE; i++){
            check = true;
            for(int j = 0; j < FIELD_SIZE; j++){
                a = (field[i][j] == sign);
                check = (check && a);
            }
            if (check == true){
                return true;
            }

        }
        return false;
    }

    public boolean checkVert(String sign){
        boolean check, a;
        for(int i = 0; i < FIELD_SIZE; i++){
            check = true;
            for(int j = 0; j < FIELD_SIZE; j++){
                a = (field[j][i] == sign);
                check = (check && a);
            }
            if (check){
                return true;
            }

        }
        return false;
    }

    public boolean checkDiagonal(String sign){
        boolean check1, check2, a, b;
        check1 = check2 = true;
        for(int i = 0; i < FIELD_SIZE; i++){
            a = (field[i][i] == sign);
            b = (field[i][2-i] == sign);
            check1 = (check1 && a);
            check2 = (check2 && b);
        }
        if (check1 == true || check2 == true){
            return true;
        }
        return false;
    }

    public boolean check(String sign){
        return (checkDiagonal(sign) || checkHor(sign) || checkVert(sign));
    }


    public boolean checkForTie(){
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++){
                if (field[i][j] == " "){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean compCheckForWinHor(){
        int xQnty, oQnty;
        for (int i = 0; i < FIELD_SIZE; i ++){
            xQnty = 0;
            oQnty = 0;
            for (int j = 0; j < FIELD_SIZE; j++){
                if (field[i][j] == "X"){
                    xQnty++;
                }
                else if (field[i][j] == "0"){
                    oQnty++;
                }
                else {
                    emptyCoordinate[0] = i + 1;
                    emptyCoordinate[1] = j + 1;
                }

            }
            if  (xQnty == 2 || oQnty == 2){
                return true;
            }
        }
        return false;
    }

    public boolean compCheckForWinVer(){
        int xQnty, oQnty;
        for (int i = 0; i < FIELD_SIZE; i ++){
            xQnty = 0;
            oQnty = 0;
            for (int j = 0; j < FIELD_SIZE; j++){
                if (field[j][i] == "X"){
                    xQnty++;
                }
                else if (field[j][i] == "0"){
                    oQnty++;
                }
                else {
                    emptyCoordinate[0] = j + 1;
                    emptyCoordinate[1] = i + 1;
                }
            }
            if  (xQnty == 2 || oQnty == 2){
                return true;
            }
        }
        return false;
    }

    public boolean compCheckForWinDiagonal(){
        int xQnty, oQnty;
        for (int i = 0; i < FIELD_SIZE; i ++){
            xQnty = 0;
            oQnty = 0;

            if (field[i][i] == "X"){
                xQnty++;
            }
            else if (field[i][i] == "0"){
                oQnty++;
            }
            else {
                emptyCoordinate[0] = i+1;
                emptyCoordinate[1] = i+1;
            }

            if  (xQnty == 2 || oQnty == 2){
                return true;
            }

        }
        return false;
    }

    public boolean compCheckForWin(){
        if (compCheckForWinHor()){
            return true;
        }
        else if (compCheckForWinVer()){
            return true;
        }
        else if (compCheckForWinDiagonal()){
            return true;
        }
        else {
            return false;
        }
    }


}
