package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service

public class CalculatorService {
    public int plus( int valueFirst,  int valueSecond) {
        return valueFirst + valueSecond;
    }

    public int minus( int valueFirst, int valueSecond) {
        return valueFirst - valueSecond;
    }

    public int multiply( int valueFirst,  int valueSecond) {
        return valueFirst * valueSecond;
    }

    public int divide( int valueFirst,  int valueSecond) {

        return valueFirst / valueSecond;
    }
}

