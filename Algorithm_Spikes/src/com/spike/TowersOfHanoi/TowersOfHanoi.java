package com.spike.TowersOfHanoi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Please write complete compilable code.
Your class should be named Solution
Read input from standard input (STDIN) and print output to standard output(STDOUT).
For more details, please check https://www.interviewstreet.com/recruit/challenges/faq/view#stdio
*/

public class TowersOfHanoi {
 
    public static void main(String[] args) {
        
    String filePath = "/Users/bkrishna/spikes/Algorithm_Spikes/src/com/spike/TowersOfHanoi/Hanoi-Moves_testcases/input00.txt";
    String input = null;
	// InputStreamReader stream = null;
	// BufferedReader reader = null;
   //  stream = new InputStreamReader(System.in);
   //  reader = new BufferedReader(stream);
   //  reader = new BufferedReader(stream);
    try {
    	BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int count = 1;
        int N=0;
        int K=0;
        String[] inputNK;
        String[] intialConfiguration = null;
        String[] finalConfiguration = null;
        
        while (reader.ready()) {
		input = reader.readLine();
            if(count==1) {
                inputNK = input.split(" ");
                N=Integer.parseInt(inputNK[0]);
                K=Integer.parseInt(inputNK[1]);
                count++;
            } else if (count==2) {
               intialConfiguration = input.split(" ");
               count++;
            } else if (count==3) {
               finalConfiguration = input.split(" ");
               count++;
            }
            
        System.out.println(input);  
       } 
        

       
        
    } catch (IOException e) {
        e.printStackTrace();
    } 
  }
}