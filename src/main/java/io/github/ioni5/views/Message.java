package io.github.ioni5.views;

public enum Message {
    
    TITLE("\nTic-Tac-Toe\n"),
    MOVE("\nLas #PLAYER's mueven."),
    PUT("\nLas #PLAYER's ponen."),
    GET_COORDINATE("\nIngresa número entre [#MIN, #MAX]: "),
    GET_COORDINATE_TO_PUT("\n¿En que posición?"), 
    GET_COORDINATE_TO_MOVE_ORIGIN("\n¿Desde que posición? "), 
    GET_COORDINATE_TO_MOVE_TARGET("\n¿Hacia que posición? "), 
    RESUME("\n¿Quieres continuar? (y/n): "), 
    ENTER_ROW("\nIngresa fila: "), 
    ENTER_COLUMN("Ingresa columna: "), 
    ENTER_NUM_OF_HUMAN_PLAYERS("\nIngresa número de jugadores [#MIN, #MAX]: "), 
    WINNER("\n¡Las #PLAYER's ganan!\n");
    
    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
