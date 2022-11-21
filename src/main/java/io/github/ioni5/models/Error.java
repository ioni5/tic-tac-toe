package io.github.ioni5.models;

public enum Error {

    INVALID_TO_PUT,
    INVALID_TO_MOVE,
    INVALID_COORDINATE,
    NULL;

    public boolean isNull() {
        return this.equals(Error.NULL);
    }
}
