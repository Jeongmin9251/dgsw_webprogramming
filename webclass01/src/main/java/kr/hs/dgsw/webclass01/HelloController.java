
package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import kr.hs.dgsw.webclass01.calculator.CalculatorService;

@RestController
public class HelloController {
    @Autowired
    private CalculatorService cs;

    @GetMapping("/calculator1")
    public int calculator1(@RequestParam int num1, @RequestParam int num2, @RequestParam String sign) {
        int result = 0;
        switch (sign) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        return result;
    }
}