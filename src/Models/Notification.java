package Models;

public record Notification(String message) {

    @Override
    public String toString() {
        return message;
    }
}
