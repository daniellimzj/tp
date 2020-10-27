package seedu.lifeasier.commands;

import seedu.lifeasier.model.notes.Note;
import seedu.lifeasier.model.notes.NoteHistory;
import seedu.lifeasier.model.notes.NoteList;
import seedu.lifeasier.parser.Parser;
import seedu.lifeasier.storage.FileStorage;
import seedu.lifeasier.model.tasks.TaskHistory;
import seedu.lifeasier.model.tasks.TaskList;
import seedu.lifeasier.ui.Ui;

public class UndoNoteCommand extends Command {

    @Override
    public void execute(Ui ui, NoteList notes, TaskList tasks, FileStorage storage, Parser parser,
                        NoteHistory noteHistory, TaskHistory taskHistory) {
        try {
            int lastNoteEditNumber = noteHistory.getLastNote().getEditNumber();
            for (int i = 0; i < notes.size(); i++) {
                int editNumOfCurrNote =  notes.get(i).getEditNumber();
                if (editNumOfCurrNote == lastNoteEditNumber) {
                    Note oldCopyOfCurrNote = noteHistory.getLastNote();
                    notes.setNote(i, oldCopyOfCurrNote);
                }
            }

            if (lastNoteEditNumber > 0) {
                ui.showUndoNoteEditMessage();
            } else if (lastNoteEditNumber < 0) {
                ui.showUndoNoteDeleteMessage();
            }
            ui.showOldNote(noteHistory);
            noteHistory.popLastNote();
            storage.saveNote();

        } catch (IndexOutOfBoundsException e) {
            ui.showInvalidUndoAction();
        }
        ui.printSeparator();
    }
}
