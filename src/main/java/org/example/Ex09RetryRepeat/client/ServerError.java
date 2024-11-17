package org.example.Ex09RetryRepeat.client;

// just for demo
public class ServerError extends RuntimeException {

    public ServerError() {
        super("server error");
    }

}
