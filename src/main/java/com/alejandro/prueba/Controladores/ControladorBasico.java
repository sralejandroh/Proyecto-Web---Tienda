package com.alejandro.prueba.Controladores;

import com.alejandro.prueba.Configuracion.Paginas;
import com.alejandro.prueba.Modelo.ModeloProductos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

//PERMITE INDICAR A SPRING QUE ESTA CLASE ES UN CONTROLADOR
@Controller
@RequestMapping("/sitio")
//FUNCIONA COMO ENDPOINT
//ES UNA RUTA EN LA QUE HABRÁN MÁS RUTAS
public class ControladorBasico {
    public List<ModeloProductos> getModelos(){
        ArrayList<ModeloProductos> modeloLista = new ArrayList<>();

        modeloLista.add(new ModeloProductos(1, "COMPUTADOR", "Computador HP | 16 RAM - Intel Core i7 - GX 3000 - 20 Pg", "http://localhost:8080/img/pc.jpeg", new Date()));
        modeloLista.add(new ModeloProductos(2, "TELEVISOR", "Televisor Samsumg | 16 RAM - HDR - Ultra Delgado - 50 Pg", "http://localhost:8080/img/tv.jpeg", new Date()));
        modeloLista.add(new ModeloProductos(3, "PLAY STATION 4", "Sony | 16 RAM - 1 Tera - Octa Core - Slim", "http://localhost:8080/img/ps4.jpeg", new Date()));
        modeloLista.add(new ModeloProductos(4, "CELULAR", "Celular Xiami | 8 RAM - Octa Core - 128 GB - 5.5 Pg", "http://localhost:8080/img/cel.jpeg", new Date()));

        return modeloLista;
    }
    //INDICA QUE ES UN MÉTODO
    //GET OBTIENE RECURSOS
    @GetMapping(path = {"/inicio", "/"})
    //SUBRUTA
    public String saludar(Model model){
        model.addAttribute("modelos", this.getModelos());
        //LLEGA A LOS TEMPLATES DE LA PÁGINA
        return "index";
    }

    //SIRVE PARA UNIR EL MODELO Y LA VISTA
    @GetMapping(path="/public")
    public ModelAndView modelo(){
        ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
        modelAndView.addObject("modelos", this.getModelos());
        return modelAndView;
    }

    @GetMapping(path = {"/producto"})
    public ModelAndView getPostUnitary(@RequestParam(defaultValue = "1", name = "id", required = false) int id){
        ModelAndView modelAndView = new ModelAndView(Paginas.PRODUCTO);
        List<ModeloProductos> filtrado = this.getModelos().stream()
                .filter( (p)->{
                    return p.getId() == id;
                }).collect(Collectors.toList());
        modelAndView.addObject("producto", filtrado.get(0));

        return modelAndView;
    }
}
