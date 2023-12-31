package gal.usc.grei.cn.precios.fachada;

import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.modelo.Pago;
import org.springframework.stereotype.Service;

@Service
public class PagoFachada {

    public Compra procesarPago(Compra compra){
        compra.setPago(new Pago());
        if (Math.random() < 0.8){
            compra.getPago().setEstado(1);
        }
        else {
            compra.getPago().setEstado(0);
        }
        return compra;
    }
}
