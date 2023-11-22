package model.expression;

import model.exception.MyException;
import model.exception.MyLogicException;
import model.type.IntType;
import model.utilis.MyIDictionary;
import model.value.BoolValue;
import model.value.IntValue;
import model.value.Value;
import model.type.BoolType;
import java.util.Objects;

public class LogicExp implements Exp{

    Exp expression_1;
    Exp expression_2;
    int operation; //1 = or , 2 = and

    @Override
    public String toString() {
        return "LogicExp{" +
                "expression_1=" + expression_1 +
                ", expression_2=" + expression_2 +
                ", operation=" + operation +
                '}';
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        Value first_value;
        Value second_value;
        first_value = expression_1.eval(tbl);
        if(Objects.equals(first_value.getType(), new BoolType()))
        {
            second_value = expression_2.eval(tbl);
            if(Objects.equals(second_value.getType(), new BoolType()))
            {
                BoolValue bool_1 = (BoolValue) first_value;
                BoolValue bool_2 = (BoolValue) second_value;

                boolean boolean_1, boolean_2;
                boolean_1 = ((BoolValue)first_value).getValue();
                boolean_2 = ((BoolValue) second_value).getValue();
                if(operation == 1)
                    return new BoolValue(boolean_1 || boolean_2);
                if(operation == 2)
                    return new BoolValue(boolean_1 && boolean_2);

            }
            else
                throw new MyLogicException("");

        }
        else
            throw new MyLogicException("");
        return new BoolValue(false);

    }
}
