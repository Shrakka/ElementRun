package com.mygdx.game;

/**
 * Created by alexis on 16/01/17.
 */

public class TriangleElement {
    public static int get(Alive A, Alive B){
        if (A.getElement().equals("fire") && B.getElement().equals("air") ||A.getElement().equals("air") && B.getElement().equals("water") || A.getElement().equals("water") && B.getElement().equals("fire")){
            return 1;
        }
        else if (A.getElement().equals("fire") && B.getElement().equals("water") || A.getElement().equals("water") && B.getElement().equals("air") || A.getElement().equals("air") && B.getElement().equals("fire")){
            return -1;
        }
        else{
            return 0;
        }
    }
}
