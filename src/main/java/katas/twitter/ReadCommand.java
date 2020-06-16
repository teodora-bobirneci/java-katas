package katas.twitter;

public class ReadCommand extends Command {
    private final String author;

    public ReadCommand(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReadCommand that = (ReadCommand) o;

        return author.equals(that.author);
    }

    @Override
    public int hashCode() {
        return author.hashCode();
    }
}
