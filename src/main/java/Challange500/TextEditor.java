package Challange500;

import java.util.Stack;

public class TextEditor {
    private StringBuilder text;
    private int cursorPosition;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public TextEditor() {
        this.text = new StringBuilder();
        this.cursorPosition = 0;
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void insertText(String textToInsert) {
        Command command = new InsertCommand(textToInsert, cursorPosition);
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // Clear redo stack on new action
    }

    public void deleteText(int length) {
        if (cursorPosition >= text.length()) {
            return;
        }

        int endPosition = Math.min(cursorPosition + length, text.length());
        String deletedText = text.substring(cursorPosition, endPosition);
        Command command = new DeleteCommand(deletedText, cursorPosition);
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void moveCursor(int position) {
        this.cursorPosition = Math.max(0, Math.min(position, text.length()));
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }

        Command command = undoStack.pop();
        command.undo();
        redoStack.push(command);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }

        Command command = redoStack.pop();
        command.execute();
        undoStack.push(command);
    }

    public String getText() {
        return text.toString();
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    // Command interface
    private interface Command {
        void execute();
        void undo();
    }

    // Insert command implementation
    private class InsertCommand implements Command {
        private String text;
        private int position;

        public InsertCommand(String text, int position) {
            this.text = text;
            this.position = position;
        }

        @Override
        public void execute() {
            TextEditor.this.text.insert(position, text);
            TextEditor.this.cursorPosition = position + text.length();
        }

        @Override
        public void undo() {
            TextEditor.this.text.delete(position, position + text.length());
            TextEditor.this.cursorPosition = position;
        }
    }

    // Delete command implementation
    private class DeleteCommand implements Command {
        private String text;
        private int position;

        public DeleteCommand(String text, int position) {
            this.text = text;
            this.position = position;
        }

        @Override
        public void execute() {
            TextEditor.this.text.delete(position, position + text.length());
            TextEditor.this.cursorPosition = position;
        }

        @Override
        public void undo() {
            TextEditor.this.text.insert(position, text);
            TextEditor.this.cursorPosition = position + text.length();
        }
    }

    // Example usage
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.insertText("Hello");
        editor.insertText(" World");
        System.out.println(editor.getText()); // "Hello World"

        editor.moveCursor(5);
        editor.insertText(", ");
        System.out.println(editor.getText()); // "Hello, World"

        editor.undo();
        System.out.println(editor.getText()); // "Hello World"

        editor.redo();
        System.out.println(editor.getText()); // "Hello, World"

        editor.moveCursor(5);
        editor.deleteText(2);
        System.out.println(editor.getText()); // "HelloWorld"

        editor.undo();
        System.out.println(editor.getText()); // "Hello, World"
    }
}