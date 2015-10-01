package com.example.vincent.ghost;

public class Game {

    // Properties of the class...
    private Lexicon lexicon;
    private String wordFormed;
    private String lettersPlayer1, lettersPlayer2;
    private int playerTurn;

    public Game(Lexicon lexicon) {
        this.lexicon = lexicon;
        wordFormed = "";
        lettersPlayer1 = "";
        lettersPlayer2 = "";
        playerTurn = 1;
    }

    public int turn() {
        return playerTurn;
    }

    public void setWordFormed(String word) {
        wordFormed = word;
    }

    public void guess(String input) {
        lexicon.filter(input);
    }

    public boolean endRound() {
        return ((lexicon.count() == 0) ||
                (lexicon.count() == 1 && wordFormed.equals(lexicon.result())));
    }

    public void setLettersPlayer1() {
        switch(lettersPlayer1) {
            case "":
                lettersPlayer1 = "G";
                break;
            case "G":
                lettersPlayer1 = "GH";
                break;
            case "GH":
                lettersPlayer1 = "GHO";
                break;
            case "GHO":
                lettersPlayer1 = "GHOS";
                break;
            case "GHOS":
                lettersPlayer1 = "GHOST";
        }
    }

    public void setLettersPlayer2() {
        switch(lettersPlayer2) {
            case "":
                lettersPlayer2 = "G";
                break;
            case "G":
                lettersPlayer2 = "GH";
                break;
            case "GH":
                lettersPlayer2 = "GHO";
                break;
            case "GHO":
                lettersPlayer2 = "GHOS";
                break;
            case "GHOS":
                lettersPlayer2 = "GHOST";
        }
    }


    public String getLettersPlayer1() {
        return lettersPlayer1;
    }

    public String getLettersPlayer2() {
        return lettersPlayer2;
    }

    public void startNewRound() {
        lexicon.reset();
        wordFormed = "";
    }

    public boolean ended() {
        return (lettersPlayer1.equals("GHOST") || lettersPlayer2.equals("GHOST"));
    }

    public int winner() {
        if(lettersPlayer1.equals("GHOST")) {
            return 2;
        }
        else {
            return 1;
        }
    }

    public void changeTurn() {
        if(playerTurn == 1) {
            playerTurn = 2;
        }
        else {
            playerTurn = 1;
        }
    }
}