package mx.unam.aragon.ico.te.musicamvc.controladores;


import mx.unam.aragon.ico.te.musicamvc.modelos.Artista;
import mx.unam.aragon.ico.te.musicamvc.servicios.ArtistaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tienda/")
public class MusicaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping("/home/")
    public String home() {
        return "home";
    }

    @GetMapping("/artista/")
    public String artista(Model model) {
        Artista artista = new Artista(1,"Freddy Mercury","Rock","Algo",25, "https://www.sopitas.com/wp-content/uploads/2014/11/freddie-mercury-e1416885817438.jpg"
               );
        model.addAttribute("artista", artista);
        return "artista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("artista", new Artista(2,"JeonKook","Rock","Algo",22,"gbnh"));
        return "formArtista";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Artista artista
    ) {
        LoggerFactory.getLogger(this.getClass()).info("Guardando artista + " + artista);
        //mandarla a BD save
        artistaService.guardarArtista(artista);
        return "redirect:/tienda/nuevo?exito";
    }
    @GetMapping("/artista/{id}")
    public String artista(@PathVariable Integer id, Model model) {
        model.addAttribute("artista",artistaService.getArtista(id));
        return "artista";
    }
}
