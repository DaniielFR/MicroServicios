package gal.usc.grei.cn.precios.repositorio;

import gal.usc.grei.cn.precios.modelo.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.Optional;

public interface CompraRepositorio extends MongoRepository<Compra, String> {
/*
    //Compra a partir de simbolo e id
    @Query(value = "{'symbol':  '?0'}")
    public Optional<Compra> findById(String id);

    @Query()
    public Compra insert(Compra compra);
*/
}
