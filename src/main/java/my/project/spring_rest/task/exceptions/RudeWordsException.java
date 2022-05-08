package my.project.spring_rest.task.exceptions;

import my.project.spring_rest.task.exceptions.IllegalTaskArgumentException;

public class RudeWordsException extends IllegalTaskArgumentException {
    public RudeWordsException() {
        super("Rude words");
    }
}
