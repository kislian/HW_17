package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//аннотация способ указать платформе для чего будем использовать метод, класс
//программа смотрит в сеть, принимет оттуда сообщение/запрос
//отправляет сообщение в ответ , чтобы понятьчто отправлять
//ищет RestController далее @GetMapping смотрит его результат и отправляет наружу
@RestController
@RequestMapping("calculator")
public class CalculatorController {
    private static final String DIVIDE_BY_ZERO = "divide by Zero";
    private static final  String MESS = "один (оба) из параметров не определён(ы)";

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String calculator() {
        return welcome();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(value = "num1", required = false)
                       Integer valueFirst, @RequestParam(value = "num2", required = false) Integer valueSecond) {
        if (verifiValue(valueFirst, valueSecond) == true) {
            return MESS;
        } else {
            return valueFirst + " + " + valueSecond + "=" + service.plus(valueFirst, valueSecond);
        }
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer valueFirst, @RequestParam(value = "num2",
            required = false) Integer valueSecond) {
        if (verifiValue(valueFirst, valueSecond) == true) {
            return MESS;
        }
        return valueFirst + " - " + valueSecond + "=" + service.minus(valueFirst, valueSecond);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer valueFirst, @RequestParam(value =
            "num2", required = false) Integer valueSecond) {
        if (verifiValue(valueFirst, valueSecond) == true) {
            return MESS;
        }
        return valueFirst + " * " + valueSecond + "=" + service.multiply(valueFirst, valueSecond);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer valueFirst, @RequestParam(value = "num2"
            , required = false) Integer valueSecond) {
        if (verifiValue(valueFirst, valueSecond) == true) {
            return MESS;
        }
        if (valueSecond == 0) {
            return DIVIDE_BY_ZERO;
        }
        return valueFirst + " / " + valueSecond + "=" + service.divide(valueFirst, valueSecond);
    }
    public String welcome() {
        return "<b><u>Welcome in  calculator</u></b>";
    }
    public Boolean verifiValue(Integer valueFirst, Integer valueSecond) {
        return (valueFirst == null || valueSecond == null);
    }
}

