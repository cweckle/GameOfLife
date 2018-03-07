//Elysia Smyers Period 3
//5 March 2018
//Life - game of life

import java.io.*;
import java.util.*;

public class Life{
    String file = "life100.txt";
    public static final int NUMROWS = 20;
    public static final int NUMCOLS = 20;

    public static void main(){
        String[][] firstGen = new String[NUMROWS][NUMCOLS];
        try{
            File file = new File("life100.txt");
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                int line = input.nextInt()-1;
                if(line != 99){
                    System.out.println(line);
                    firstGen[line][input.nextInt()-1] = "*";
                }
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        go(firstGen);
    }

    public static void go(String[][] firstGen){
        String[][] secondGen = new String[NUMROWS][NUMCOLS];
        for(int i = 0; i < 5; i ++){
            for(int row = 0; row < firstGen.length; row ++){
                for(int col = 0; col < firstGen[0].length; col ++){
                    boolean birthable = false;
                    int neighbs = checkNeighbors(firstGen, row, col);
                    if(firstGen[row][col] == null){
                        if(neighbs==3)
                            secondGen[row][col] = "*";
                    }
                    else{
                        if(neighbs == 1 || neighbs == 0)
                            secondGen[row][col] = "-";
                        else if(neighbs == 2 || neighbs == 3)
                            secondGen[row][col] = "*";
                    }
                    print(secondGen);
                }
            }
        }
    }

    public static void print(String[][] secondGen){
        for(int row = 0; row < secondGen.length; row ++){
            for(int col = 0; col < secondGen[0].length; col ++){
                if(secondGen[row][col] == null)
                    System.out.print("-");
                else
                    System.out.print(secondGen[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int checkNeighbors(String[][] firstGen, int row, int col){
        int neighbs = 0;
        for(int newRow = row - 1; newRow <= row + 1; newRow ++){
            for(int newCol = col - 1; newCol <= col + 1; newCol ++){
                if((newRow != row && newCol != col) && (newRow >= 0 && newCol >= 0) && (newRow < NUMROWS && newCol < NUMCOLS))
                    if(firstGen[newRow][newCol] != null)
                        neighbs ++;
            }
        }
        return neighbs;
    }
}