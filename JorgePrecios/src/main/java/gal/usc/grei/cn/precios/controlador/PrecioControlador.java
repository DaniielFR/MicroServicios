package gal.usc.grei.cn.precios.controlador;

import gal.usc.grei.cn.precios.fachada.PrecioFachada;
import gal.usc.grei.cn.precios.modelo.Precio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/precios")
public class PrecioControlador {
    private final PrecioFachada precios;
    /**
     * Constructor de la clase
     * @param precios Instancia de la clase PrecioFachada
     * */
    @Autowired
    public PrecioControlador(PrecioFachada precios) {
        this.precios = precios;
    }


    /** * Método: GET
     * Url para llegar: /precios
     * Objetivo: recuperar la acción en base a su símbolo.
     * @param simbolo El símbolo de la acción a recuperar
     * @return Si el simbolo es válido, los datos de la acción.
     * */
    @GetMapping(
            path = "{simbolo}",
            produces = MediaType.APPLICATION_JSON_VALUE
    ) ResponseEntity<Precio> get(@PathVariable("simbolo") String simbolo) {
        return ResponseEntity.of(precios.get(simbolo));
    }

}