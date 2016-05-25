import java.io.*;
public class GameLogic {
	
			static char [][] matrix;
			
			String finalString = "";
	
			public GameLogic(String line){

            line = line.trim();
            
            String matrixValsString = line.substring(0, line.indexOf(';'));
            
            String gameLine = line.substring(line.indexOf(';') + 1);
            
            
            int m = Integer.parseInt(matrixValsString.substring(0, line.indexOf(',')).replaceAll(" ", ""));
            int n = Integer.parseInt(matrixValsString.substring(line.indexOf(',') + 1).replaceAll(" ", ""));
 
            matrix = new char[m][n];
            
            int counter = 0;
            
            for(int i = 0; i < m; i++){
               for(int j = 0; j < n; j++){
                  
                  matrix[i][j] = gameLine.charAt(counter);
                  
                  counter++;
               }
            }
            
            
            char [] finalOrder = new char [m*n];
            
            
            int order = 0;
            
            
            for(int i = 0; i < m; i++){
               for(int j = 0; j < n; j++){
               
                  char current = matrix[i][j];
                  
                  if(current == '*'){
                  
                  
                     finalOrder[order] = '*';
                     
                     
                  }else if(current == '.'){
                     
                     int mineCounter = 0;
                     
                     boolean vals [] = new boolean[8];
                     
                     vals[0] = isMine(i - 1, j - 1);
                     vals[1] = isMine(i - 1, j);
                     vals[2] = isMine(i - 1, j + 1);
                     vals[3] = isMine(i, j - 1);
                     vals[4] = isMine(i, j + 1);
                     vals[5] = isMine(i + 1, j - 1);
                     vals[6] = isMine(i + 1, j);
                     vals[7] = isMine(i + 1, j + 1);
                     
                     for(int x = 0; x < vals.length; x++){
                        if(vals[x] == true){
                           mineCounter++;
                        }
                     }
                     
                     finalOrder[order] = String.valueOf(mineCounter).charAt(0);
                  }
               
                  order++;
                  
               }
               
            }
            
            //printing
            for(int i = 0; i < finalOrder.length; i++){
               System.out.print(finalOrder[i]);
               finalString += finalOrder[i];
            }
            
        }
        
       
    
    public static boolean isMine(int m, int n){
         
            boolean isMine = false;
         
            try{
            
               char curr = matrix[m][n];
               
               if(curr == '*'){
                  isMine = true;
               }
            
            
            }catch(Exception e){
               isMine = false;
            }
                 
            return isMine;
            
        }
     
	}
