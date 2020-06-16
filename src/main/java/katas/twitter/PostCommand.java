package katas.twitter;

public class PostCommand extends Command {
    private final String recipient;
    private final String message;

    public PostCommand(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostCommand that = (PostCommand) o;

        return recipient.equals(that.recipient) &&
                message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return recipient.hashCode() * 31 + message.hashCode() * 31;
    }
}
