package gal.usc.grei.cn.precios.modelo;

import org.springframework.data.annotation.Id;

public class Pago {

    @Id
    private String id;
    private int estado;

    private String tarjeta;

    public int getEstado() {return estado; }

    public String getTarjeta() {return tarjeta;}

    public Pago setEstado(int estado){
        this.estado = estado;
        return this;
    }

    public Pago setTarjeta(String tarjeta){
        this.tarjeta = tarjeta;
        return this;
    }
}
