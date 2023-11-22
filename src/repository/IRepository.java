package repository;
import model.program_state.*;
import model.exception.MyException;

import java.io.IOException;

public interface IRepository {
    ProgramState getCurrentProgramState();
    void add(ProgramState programState);

    void savePrgStateinLOG() throws MyException, IOException;
}
