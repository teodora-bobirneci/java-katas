package katas.twitter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandInterpreterShould {

    private CommandInterpreter commandInterpreter = new CommandInterpreter();

    @Test public void identify_a_posting_command(){
        assertThat(commandInterpreter.interpret("> alice -> hello!")).isEqualTo(new PostCommand("alice", "hello!"));
    }

    @Test public void identify_a_read_command(){
        assertThat(commandInterpreter.interpret("> alice")).isEqualTo(new ReadCommand("alice"));
    }

    @Test public void identify_a_follow_command(){
        assertThat(commandInterpreter.interpret("> alice follows bob")).isEqualTo(new FollowCommand("alice", "bob"));
    }

}
