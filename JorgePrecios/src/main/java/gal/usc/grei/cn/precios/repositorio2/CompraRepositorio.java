package gal.usc.grei.cn.precios.repositorio2;

import gal.usc.grei.cn.precios.modelo.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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
