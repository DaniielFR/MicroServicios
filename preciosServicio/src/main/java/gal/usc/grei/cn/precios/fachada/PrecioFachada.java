package gal.usc.grei.cn.precios.fachada;

import gal.usc.grei.cn.precios.modelo.Precio;
import gal.usc.grei.cn.precios.repositorio.PrecioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrecioFachada {

    private final PrecioRepositorio precios;

    /**
     * Constructor de la clase
     * @param precios Referencia al PrecioRepositorio
     * */
    @Autowired
    public PrecioFachada(PrecioRepositorio precios) {
        this.precios = precios;
    }

    /**
     * Método que permite recuperar el precio de una acción por su símbolo.
     * @param simbolo El simbolo de la accion a recuperar
     * @return Los datos de la accion con los parámetros facilitados (si se encuentra).
     * */
    public Optional<Precio> get(String simbolo) {
        return precios.findPrecioBySymbolAndDate(simbolo, "2010-01-04");
    }
}