/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_q2;

import java.util.Scanner;

/**
 *
 * @author bapti
 */
public class RabbitJump {

    /**
     * @param args the command line arguments
     */
    private int [] rockPosition;
    int nombre;
    int jumpNumber;
    
    
    public void RabbitJump (int n) //constructor
    {
        nombre = n;
        rockPosition  = new int [n];
        
    }
    
    public int [] boardRock(int n,int rockPosition[] ) // method to implement the array of rock position
    {
        Scanner userChoice = new Scanner(System.in);
        for (int i = 0; i < n; i++)
        {
            System.out.println("give the position of the rock : "  + (i+1));
            rockPosition [i] = userChoice.nextInt();
            
        }
        
        return rockPosition;
    }
    
    public int jump (int n, int rockPosition[]) //methode to calculate the minim jum needed
    {
        for (int i = 0; i < n; i++) 
        {
                for (int j = 50; j > 0 ; j--)
                {
                    if (rockPosition[i] == j) // if j of jump is equal to the rock position, the rabbit can jump on it and we add 1 to jumNumber
                                              //the probleme is that max (j) is 50 and the rock position can be higher so it just work for the first jump 
                    {
                        System.out.println("dans le if");
                        //rockPosition[i+1] -=  j;
                        jumpNumber ++;
                    }
                    
                    if (i != 0) // condition required otherxise we can be out of bound for i = 0
                    {
                        if (rockPosition[i] == j + rockPosition[i - 1]) // general condition to make all the other jump to cross the river
                        {
                            System.out.println("dans le else if if ");
                            jumpNumber ++;
                        }
                        
                        if (rockPosition[i] > rockPosition[i-1] + 50 ) // if the user choose two values separate by more than 50 
                        {
                            return jumpNumber = -1;
                        }
                    }
                }
        }
        
        return jumpNumber;
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int nombre;
        int jumpN = 0;
        
        Scanner userNumber = new Scanner (System.in);
        System.out.println("choose the number of rocks");
        nombre = userNumber.nextInt(); // we have the number of rock
        
        int rockP [] = new int [nombre];
        
        
        
        RabbitJump rab = new RabbitJump ();
        
        rockP = rab.boardRock(nombre, rockP); // each rock has a position
        
        
        jumpN = rab.jump(nombre, rockP); // the number of jump is known
        
        
        // print everything
        
        for (int i = 0; i < rockP.length; i++) 
        {
            System.out.println("position of the rock : " + (i+1));
            System.out.println(rockP[i]);
        }
        
        System.out.println("nomber of jumps : ");
        System.out.println(jumpN );   
    }
}
