package com.example.mamunjahir.clocktest.utils;

import java.util.Random;

public class NumberProblems {
    static int num1, num2;
    static String Type_of_Math;
    Random random = new Random();

    // Constructors
    public NumberProblems(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public NumberProblems() {

    }

    //getters and setters
    public static int getNum1() {
        return num1;
    }

    public static void setNum1(int num1) {
        NumberProblems.num1 = num1;
    }

    public static int getNum2() {
        return num2;
    }

    public static void setNum2(int num2) {
        NumberProblems.num2 = num2;
    }

    public static String getType_of_Math() {
        return Type_of_Math;
    }

    public static void setType_of_Math(String type_of_Math) {
        Type_of_Math = type_of_Math;
    }

    public int getRandom(int a) {
        return random.nextInt(a);
    }

    //Math clculations
    public int getaddtion() {
        return num1 + num2;
    }

    public int getsubtraction() {
        return num2 - num1;
    }

    public int getmultiplication() {
        return num1 * num2;
    }

}
