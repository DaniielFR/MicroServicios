package gal.usc.grei.cn.precios.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "compras")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Compra {
    @Id
    private String id;
    private String fecha;
    @NotEmpty(message = "El símbolo no puede ser vacío")
    private String simbolo;
    @NotNull(message = "El volumen no puede ser vacío")
    private Long volumen;
    @NotNull(message = "El precio por unidad no puede ser vacío")
    private Float unidad;
    @NotNull(message = "El precio total no puede ser vacío")
    private Float total;

    private Pago pago;

    public Pago getPago() {return this.pago;}
    public Compra setPago(Pago pago) {
        this.pago = pago;
        return this;
    }

    public String getId() {
        return id;
    }

    public Float getTotal() {
        return total;
    }

    public Float getUnidad() {
        return unidad;
    }

    public Long getVolumen() {
        return volumen;
    }

    public String getFecha() {
        return fecha;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public Compra setFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public Compra setId(String id) {
        this.id = id;
        return this;
    }

    public Compra setSimbolo(String simbolo) {
        this.simbolo = simbolo;
        return this;
    }

    public Compra setTotal(Float total) {
        this.total = total;
        return this;
    }

    public Compra setUnidad(Float unidad) {
        this.unidad = unidad;
        return this;
    }

    public Compra setVolumen(Long volumen) {
        this.volumen = volumen;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", volumen=" + volumen +
                ", unidad=" + unidad +
                ", total=" + total +
                '}';
    }
}
