package mx.unam.aragon.ico.te.musicamvc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {
    @GetMapping("/")
    public String obtenerInicial() {
        return "index";
    }
}
