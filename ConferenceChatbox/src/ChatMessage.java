public class ChatMessage {

    private String sender;
    private String message;
    private String type;
    private String timestamp;

    public ChatMessage(
            String sender,
            String message,
            String type) {

        this.sender = sender;
        this.message = message;
        this.type = type;
        this.timestamp =
                java.time.LocalDateTime.now()
                .toString();
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {

        return "[" + timestamp + "] "
                + type + " | "
                + sender + " : "
                + message;
    }
}