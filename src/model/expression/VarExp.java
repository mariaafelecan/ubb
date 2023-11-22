package model.expression;

import model.exception.MyException;
import model.utilis.MyIDictionary;
import model.value.Value;

public class VarExp implements Exp{
    String id;

    public VarExp(String v) {
        id = v;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        return tbl.lookUp(id);
    }

    @Override
    public String toString() {
        return "VarExp{" +
                id +
                '}';
    }
}
