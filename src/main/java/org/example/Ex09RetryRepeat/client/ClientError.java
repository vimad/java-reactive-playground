package org.example.Ex09RetryRepeat.client;

// just for demo
public class ClientError extends RuntimeException {

    public ClientError() {
        super("bad request");
    }

}
