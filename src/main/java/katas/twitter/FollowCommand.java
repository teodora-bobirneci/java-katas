package katas.twitter;

public class FollowCommand extends Command{
    private final String follower;
    private final String following;

    public FollowCommand(String follower, String following) {
        this.follower = follower;
        this.following = following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowCommand that = (FollowCommand) o;

        if (!follower.equals(that.follower)) return false;
        return following.equals(that.following);
    }

    @Override
    public int hashCode() {
        int result = follower.hashCode();
        result = 31 * result + following.hashCode();
        return result;
    }
}
