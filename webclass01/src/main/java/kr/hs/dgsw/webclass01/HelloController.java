
package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "hello world";
    }

    @GetMapping("/calculator1")
    public int calculator1(@RequestParam int num1, @RequestParam int num2, @RequestParam String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
        }

        return res;
    }

    @GetMapping("/calculator2/{n1}/{oper}/{n2}")
    public int calculator2(@PathVariable String n1, @PathVariable String n2, @PathVariable String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = Integer.parseInt(n1) + Integer.parseInt(n2);
                break;
            case "-":
                res = Integer.parseInt(n1) - Integer.parseInt(n2);
                break;
            case "*":
                res = Integer.parseInt(n1) * Integer.parseInt(n2);
                break;
            case "/":
                res = Integer.parseInt(n1) / Integer.parseInt(n2);
                break;
        }

        return res;
    }
}