package gal.usc.grei.cn.pagos.controlador;

import gal.usc.grei.cn.pagos.fachada.PagoFachada;
import gal.usc.grei.cn.pagos.modelo.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pago")
public class PagoControlador {

    private PagoFachada pago;
    @Autowired
    public PagoControlador(PagoFachada pago){
        this.pago = pago;
    }

    @PostMapping
    public ResponseEntity<String> pagar(@RequestHeader("Autentificacion") String autentificacion,
                                        @Valid @RequestBody Compra compra){
        //Chequeamos que se hace desde dentro y no desde fuera

        System.out.println("2");
        System.out.println(autentificacion);
        System.out.println(compra);

        if("contrasenha".equals(autentificacion)){
            System.out.println("3");
            return new ResponseEntity<String>(pago.procesarPago(compra), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No autorizado", HttpStatus.UNAUTHORIZED);
        }
    }
}
