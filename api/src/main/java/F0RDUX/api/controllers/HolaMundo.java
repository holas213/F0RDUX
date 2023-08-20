package F0RDUX.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
    @GetMapping("prueba")
    public String prueba()
    {
        return "Emerson rctmr";
    }
}
