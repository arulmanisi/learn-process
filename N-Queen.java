/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.lang.StringBuilder;
import java.util.scanner;
/**
 *
 * @author asennima
 * Reference https://sites.fas.harvard.edu/~libs111/code/recursion2/Queens.java
 */
public class nQueen {
    
    static int BOARD_SIZE;
    static boolean[] colSafe;
    static boolean[] upDiag;
    static boolean[] downDiag;
    static char[][] puzzle;
    
    public static boolean isSafe(char[][] puzzle,int row, int col){
        //System.out.println(col);
        return (colSafe[col] &&
                upDiag[row+col] &&
                downDiag[(BOARD_SIZE-1)+row-col]);
        
        /*return ( upDiag[row+col] &&
                downDiag[(BOARD_SIZE-1)+row-col]);*/
    }
    
    public static void placeQueen(char[][] puzzle,int row, int col){
        puzzle[row][col] = 'Q';
        colSafe[col] = false;
        upDiag[row+col] = false;
        downDiag[(BOARD_SIZE-1)+row-col] = false;
    }
    
    public static void removeQueen(char[][] puzzle,int row, int col){
        puzzle[row][col] = '.';
        colSafe[col] = true;
        upDiag[row+col] = true;
        downDiag[(BOARD_SIZE-1)+row-col] = true;
    }
    
    public static List<List<String>> solveNQueens(int n) {        
        puzzle = new char[n][n];
        colSafe = new boolean[n];
        upDiag = new boolean[n*2-1];
        downDiag = new boolean[n*2-1];
        BOARD_SIZE = n;
        System.out.println(BOARD_SIZE);
        for(int i=0;i<BOARD_SIZE;i++)
            Arrays.fill(puzzle[i], '.');
        Arrays.fill(colSafe, true);
        Arrays.fill(upDiag, true);
        Arrays.fill(downDiag, true);
        //BOARD_SIZE = n;
        
        List<List<String>> output = new ArrayList<>();        
        recurseBT(puzzle, output, 0);        
        return output;
    }
    
    public static void recurseBT(char[][] puzzle, List<List<String>> output, int row){
        if(row == BOARD_SIZE){
            List<String> templist = new ArrayList<>();
            //String str = "";            
            for(int i=0;i<BOARD_SIZE;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<BOARD_SIZE;j++){
                    sb.append(puzzle[i][j]);       
                }
                templist.add(sb.toString());
            }
            output.add(templist);
            return;
        }
        
        for(int col=0;col<BOARD_SIZE;col++) { // For each column
            if(isSafe(puzzle,row,col)){
                placeQueen(puzzle, row, col);
                recurseBT(puzzle, output, row+1);
                removeQueen(puzzle, row, col);
            }    
        }
    }
            
    public static void main(String[] args){
        int n = 0;
        Scanner in = new Scanner();
        System.out.println("Provide the size of board N x N");
        n = in.nextInt();
        System.out.println(solveNQueens(n));
    }
}
