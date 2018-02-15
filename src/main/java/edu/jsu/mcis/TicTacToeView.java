package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        System.out.print("\n\n");
        System.out.print("  ");
        for (int p = 0; p < model.getWidth(); p++) {
            System.out.print(p);
        }
        System.out.print("\n");
        for (int i = 0; i < model.getWidth(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < model.getWidth(); j++){
               System.out.print(model.getMark(i, j));
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        if (model.isXTurn()){
            System.out.println("Player 1 (X) Move:\n" +
            "Enter the row and column numbers, separated by a space: ");
        }
        else {
            System.out.println("Player 2 (O) Move:\n" +
            "Enter the row and column numbers, separated by a space: ");
        }

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("Invalid Input");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}
