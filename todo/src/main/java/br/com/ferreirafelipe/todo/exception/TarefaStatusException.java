package br.com.ferreirafelipe.todo.exception;

public class TarefaStatusException extends RuntimeException{
    public TarefaStatusException(String message) {
        super(message);
    }

    public TarefaStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public TarefaStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TarefaStatusException(Throwable cause) {
        super(cause);
    }
}
