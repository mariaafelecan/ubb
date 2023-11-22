package model.stmt;

import model.exception.MyException;
import model.program_state.ProgramState;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IStmt {
    ProgramState execute(ProgramState state) throws MyException, IOException;
}