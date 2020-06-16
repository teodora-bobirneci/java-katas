package katas.twitter;

public class CommandInterpreter {

    public Command interpret(String commandStr) {
        if (commandStr.matches(".* -> .*")) {
            String[] parts = commandStr.split(" -> ");
            return new PostCommand(sanitize(parts[0]), sanitize(parts[1]));
        } else if (commandStr.matches("> [a-zA-Z]+")){
            return new ReadCommand(sanitize(commandStr));
        } else if (commandStr.matches("> [a-zA-Z]+ follows [a-zA-Z]+")) {
            String[] parts = commandStr.split(" follows ");
            return new FollowCommand(sanitize(parts[0]), sanitize(parts[1]));
        }
       throw new IllegalArgumentException("Could not parse command " + commandStr);
    }

    private String sanitize(String operand) {
        return operand.replace(">","").trim();
    }
}
