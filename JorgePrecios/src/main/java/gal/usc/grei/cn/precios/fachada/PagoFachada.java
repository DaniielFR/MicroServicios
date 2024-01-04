package gal.usc.grei.cn.precios.fachada;

import gal.usc.grei.cn.precios.modelo.Compra;
import gal.usc.grei.cn.precios.modelo.Pago;
import org.springframework.stereotype.Service;

@Service
public class PagoFachada {

    public String procesarPago(Compra compra){
        System.out.println(compra.toString());

        if(validarTarjeta(compra.getTarjeta())){

            return("pagoRealizado");
        }
        else{
            return("pagoFallido");
        }
    }

    //https://noticiatecnologia.com/validar-numero-de-tarjeta-de-credito-en-java/
    //requiere que la tarjeta sea toda seguida como en los ejemplos de requests
    private boolean validarTarjeta(String tarjeta){
        if (tarjeta == null || tarjeta.isEmpty()) return false;
        boolean x = true;
        int sum = 0;
        int temp = 0;

        for (int i = tarjeta.length() - 1; i >= 0; i--) {
            temp = tarjeta.charAt(i) - '0';
            sum += (x = !x) ? temp > 4 ? temp * 2 - 9 : temp * 2 : temp;
        }

        return sum % 10 == 0;
    }
}
