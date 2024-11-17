package org.example.Ex10Sinks.assignment;

public record SlackMessage(String sender,
                           String message) {

    private static final String MESSAGE_FORMAT = "[%s -> %s] : %s";

    public String formatForDelivery(String receiver){
        return MESSAGE_FORMAT.formatted(sender, receiver, message);
    }

}
