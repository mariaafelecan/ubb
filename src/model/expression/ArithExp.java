package model.expression;

import model.exception.MyArithmeticException;
import model.exception.MyException;
import model.type.IntType;
import model.utilis.MyIDictionary;
import model.value.IntValue;
import model.value.Value;

import java.util.Objects;

public class ArithExp implements Exp{

    Exp first_expression;
    Exp second_expression;
    int operation; //1 = plus, 2 = minus, 3 = multiplication, 4 = divide

    public ArithExp(int c, Exp valueExp1, Exp valueExp2) {
        operation = c;
        first_expression = valueExp1;
        second_expression = valueExp2;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        Value first_value;
        Value second_value;
        first_value = first_expression.eval(tbl);
        if(Objects.equals(first_value.getType(), new IntType()))
        {
            second_value = second_expression.eval(tbl);
            if(Objects.equals(second_value.getType(), new IntType()))
            {
                IntValue integer_1 = (IntValue) first_value;
                IntValue integer_2 = (IntValue) second_value;

                int number_1, number_2;
                number_1 = ((IntValue) first_value).getValue();
                number_2 = ((IntValue) second_value).getValue();
                if(operation == 1)
                    return new IntValue(number_1 + number_2);
                if(operation == 2)
                    return new IntValue(number_1 - number_2);
                if(operation == 3)
                    return new IntValue(number_1 * number_2);
                if(operation == 4)
                    if(number_2!= 0)
                        return new IntValue((number_1 / number_2));
                    else
                        throw new MyException("error: division by 0 !");

            }
            else
                throw new MyArithmeticException("");

        }
        else
            throw new MyArithmeticException("");
        return new IntValue(0);
    }

    @Override
    public String toString() {
        return "ArithExp{" +
                "first=" + first_expression +
                ", second=" + second_expression +
                ", operation=" + operation +
                '}';
    }
}
