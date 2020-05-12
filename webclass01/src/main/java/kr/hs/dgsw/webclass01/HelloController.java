
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

    /*@GetMapping("/calculator2/{num1}/{sign}/{num2}")
    public String calculator2(@PathVariable String num1, @PathVariable String num2, @PathVariable String sign) {

        String result = cs.validation(num1, num2, sign);
        System.out.println(result);
        if(result == "OK") { 
            return "결과값: " + cs.calculator(num1, num2, sign); 
        }
        else { 
            return result; 
        }
    }*/
}