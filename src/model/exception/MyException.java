package model.exception;

import model.exception.IMyException;

public class MyException extends Exception implements IMyException {
    public MyException(String message)
    {
        super(message);
    }

    @Override
    public void handleMyException()
    {
    }
}
