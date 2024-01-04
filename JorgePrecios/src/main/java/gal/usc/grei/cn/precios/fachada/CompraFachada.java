package gal.usc.grei.cn.precios.fachada;

import gal.usc.grei.cn.precios.Configuracion.RTConfig;
import gal.usc.grei.cn.precios.controlador.PagoControlador;
import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.repositorio.CompraRepositorio;
import gal.usc.grei.cn.precios.repositorio.PrecioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class CompraFachada {

    @Autowired
    private RestTemplate restTemplate;

    private CompraRepositorio compras;
    /*
    * Constructor de la clase
    * @param compras Referencia al CompraRepositorio
    */
    public CompraFachada(CompraRepositorio compras) {
        this.compras = compras;
    }
    public Optional<Compra> get(String id) {
// Se recupera la compra por el id
        return compras.findById(id);
    }
    /**
     * Método que permite insertar una nueva compra en la base de datos.
     * @param compra Los datos de la compra a insertar.
     * @return Los datos de la compra una vez insertados, incluyendo el id.
     * @throws ResponseStatusException Excepción lanzada en caso de que se facilite alguna
    información incorrecta.
     */
    public Optional<Compra> create(Compra compra) {

        if (compra.getId() == null || compra.getId().isEmpty()) {
            //Insertamos la compra en la bd
            compra.setEstado(0);
            Compra nCompra = compras.insert(compra);

            /*
            DESCOMENTAR SI SE QUIERE PROBAR QUE EL PATRON FUCIONA CON EL MONGO COMPASS
            //Para probar que el patron funciona
            try {
                System.out.println("Paramos?");
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e){
                System.out.println("Error");
            }
            */

            //Hacemos la peticion para pago (con la contraseña contrasenha para hacerlo medio privado (se podría hacer mejor con un
            //.java con @configuration
            HttpHeaders cabecera = new HttpHeaders();
            cabecera.set(
                    "Autentificacion", "contrasenha"
            );

            HttpEntity<Compra> peticion = new HttpEntity<>(nCompra, cabecera);

            System.out.println("1");

            ResponseEntity<String> respuesta = restTemplate.exchange(
                    "http://localhost:8081/pago", HttpMethod.POST, peticion, String.class
            );

            //En base a la respuesta

            if(respuesta.getBody().equals("pagoRealizado")) {
                nCompra.setEstado(1);
                compras.save(nCompra);
                return Optional.of(nCompra);
            }
            else
            {
                compras.delete(compra);
                System.out.println("PagoFallado");
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
