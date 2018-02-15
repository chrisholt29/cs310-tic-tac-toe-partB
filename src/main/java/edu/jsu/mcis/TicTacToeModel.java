package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        grid= new Mark[width][width]; 

        /* Initialize grid by filling every square with empty marks */

        for (int w=0;w<width;w++){
		for (int h=0;h<width;h++){
		grid[w][h]=Mark.Empty;
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        if (xTurn && isValidSquare(row, col) && !isSquareMarked(row,col)){
		grid[row][col].equals(Mark.X);
		xTurn = false; 
		return true;
	}
	else if (!xTurn && isValidSquare(row, col) && !isSquareMarked(row,col)){
		grid[row][col].equals(Mark.O);
		xTurn = true;
		return true; 
	}
	else {
		return false; 
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        if ((row<width) && (row>=0) && (col<width) && (col>=0)){
		return true;
	}
	else {
		return false;
	}	
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        if (grid[row][col]!=Mark.EMPTY){
		return true;
	}	
        else{
		return false;
	}	 
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        if (grid[row][col].equals(Mark.X)){
        	return Mark.X;
	}
	else if (grid[][].equals(Mark.O)){
		return Mark.O;
	}
	else {
		return Mark.EMPTY;
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
      if (isMarkWin(Mark.X)){
	      return Result.X;
      }
      else if (isMarkWin(Mark.O)){
	      return Result.O;
      }
      else if (isTie()){
	      return Result.TIE;
    } else {
	      return Result.NONE;
      }
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        int j;
        checkRow: for (int i = 0; i < width; i++){
            for (j = 0; j < width; j++){
                if(!grid[i][j].equals(mark)){
                    break checkRow;
                }
                if(j == width - 1){
                    return true;
                }           
            }
        }
	int k;
        checkCol: for (int p = 0; p < width; p++){
            for (k = 0; k < width; k++){
                if (!grid[k][p].equals(mark)){
                    break checkCol;
                }
                if (k == width - 1){
                    return true;
		}          
            }
        }    
	checkDiag: for (int v = 0; v < width; v++){
            if (!grid[v][v].equals(mark)){
                break checkDiag;
            }
            if (v == width -1){
                return true;
            }                        
        }
	checkAnti: for (int n = 0; n < width; n++){
            if (!grid[n][width - 1 - n].equals(mark)){
                break checkAnti;
            }
            if (n == width - 1){
                return true;
            }                
        }   
	return false;    
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        for (int i = 0; i < width; i++){
           for (int j=0; j < width; j++){
               if((!isSquareMarked(i, j)) || (isMarkWin(grid[i][j]))){
                   return false;
               }
           }
        }
        return true;
        
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}
