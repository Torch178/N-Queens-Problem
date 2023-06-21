package cs2130;

public class Nqueens {

    private int n;
    int[] queens;

    public Nqueens(int n){
        this.n = n;
        queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = -1;
        }
    }

    public int[] getQueens() {
        return queens;
    }

    public void setQueens(int[] queens) {
        this.queens = queens;
    }

    public void printSolution(){
        //TODO:
        /*Print the board using the positioning found in the
        queens array.  If queens[0] = -1 you should print "No solution"
        When printing the board use "|" to separate columns and
        new lines to separate rows.  Mark queens with a "Q" and empty
        squares with a " "
         */
         if(queens[0] == -1){
            System.out.println("No solution");
         }
         else{
            for(int i = 0;i < n; i++){
            System.out.print("|");
               for(int j = 0; j <n; j++){
                  if( queens[i] == j){ System.out.print("Q");}
                  else{ System.out.print(" ");}
                  System.out.print("|");
               }
               System.out.println("");
            }
         }
         
         
    }

    boolean isValid(int rows){
        
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < rows; j++){
                if(i != j){
                    if(queens[i] == queens[j]){ return false; } //queens are in same column, return false. Invalid placement.
                    if((queens[i] + i == queens[j] + j) || (i - queens[i] == j - queens[j]) ){ return false; }// queens are in same diagonal row, return false. Invalid placement.
                }

            }
        }
        return true;
    }


    private boolean backtrack(int row){

        if (row == n){
            return isValid(row);
        }
        for (int col = 0; col < n; col++) {
            queens[row] = col;
            if (isValid(row+1) && backtrack(row+1)){
                return true;
            } 
            queens[row] = -1;
        }
        return false;
    }

    public void backtrackingFindSolution(){
        backtrack(0);
    }

    private boolean bruteforce(int row){
        if (row == n){
            return isValid(row);
        }
        for (int col = 0; col < n; col++) {
            queens[row] = col;
            if(bruteforce(row+1)){
                return true;
            }
            queens[row] = -1;
        }
        return false;
    }

    public void bruteForceFindSolution(){
        bruteforce(0);
    }


}
