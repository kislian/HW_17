package pro.sky.calculator;

import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.Integer.parseInt;

public class CalculatorService {
    public String welcome() {
        return "<b><u>Welcome in  calculator</u></b>";
    }

    public Boolean verifiValue(Integer valueFirst, Integer valueSecond) {
        return (valueFirst == null || valueSecond == null);
    }

    public int plus(@RequestParam("num1") int valueFirst, @RequestParam("num2") int valueSecond) {
        return valueFirst + valueSecond;
    }

    public int minus(@RequestParam("num1") int valueFirst, @RequestParam("num2") int valueSecond) {
        return valueFirst - valueSecond;
    }

    public int multiply(@RequestParam("num1") int valueFirst, @RequestParam("num2") int valueSecond) {
        return valueFirst * valueSecond;
    }

    public int divide(@RequestParam("num1") int valueFirst, @RequestParam("num2") int valueSecond) {

        return valueFirst / valueSecond;
    }
}

