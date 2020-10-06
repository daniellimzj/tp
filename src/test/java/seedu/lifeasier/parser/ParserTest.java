package seedu.lifeasier.parser;

import org.junit.jupiter.api.Test;
import seedu.lifeasier.commands.Command;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseCommand_inputHelp_expectHelpCommand() throws ParserException {
        Parser parser = new Parser();
        String inputString = "help ";
        Command parsedCommand = parser.parseCommand(inputString);
        assertEquals("helpcommand", parsedCommand.testOutput());
    }
}