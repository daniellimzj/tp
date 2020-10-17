package seedu.lifeasier.storage;

import org.junit.jupiter.api.Test;
import seedu.lifeasier.notes.Note;
import seedu.lifeasier.notes.NoteList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoteStorageTest {

    private static final String EXPECTED_STRING_OUTPUT_NOTES =
            "Cats are awesome!=-=Cats are so cute, they are the best :D" + System.lineSeparator();
    private static final String TEST_NOTE_PATH = "testNotes.txt";
    private NoteStorage noteStorage;

    public NoteStorageTest() {
        this.noteStorage = new NoteStorage(new NoteList(), TEST_NOTE_PATH);
    }

    @Test
    void convertNoteToString_newNote_correctStringOutput() {
        Note note = new Note("Cats are awesome!  ", "  Cats are so cute, they are the best :D  ");
        String output = noteStorage.convertNoteToString(note);
        assertEquals(EXPECTED_STRING_OUTPUT_NOTES, output);
    }

}