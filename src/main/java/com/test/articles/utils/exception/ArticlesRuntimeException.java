package com.test.articles.utils.exception;

public class ArticlesRuntimeException extends RuntimeException {

    public ArticlesRuntimeException() {
    }

    public ArticlesRuntimeException(String message) {
        super(message);
    }

    public ArticlesRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticlesRuntimeException(Throwable cause) {
        super(cause);
    }
}
