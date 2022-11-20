package io.github.ioni5;

public enum Message {
    
    TITLE("\nTic-Tac-Toe\n"),
    MOVE("\nLas #PLAYER mueven."),
    PUT("\nLas #PLAYER ponen."), 
    GET_COORDINATE_TO_PUT("\n¿En que posición?"), 
    GET_COORDINATE_TO_MOVE_ORIGIN("\n¿Desde que posición?"), 
    GET_COORDINATE_TO_MOVE_TARGET("\n¿Hacia que posición?"), 
    RESUME("\n¿Quieres continuar? (y/n): ");
    
    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
