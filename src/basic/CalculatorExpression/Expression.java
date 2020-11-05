package basic.CalculatorExpression;

import java.util.HashMap;

public abstract class Expression {

    /**
     * 解析公式和数值，var中的key值是公式中的参数，value是具体的数字
     *
     * @param var
     * @return
     */
    public abstract int interpreter(HashMap<String, Integer> var);
}
