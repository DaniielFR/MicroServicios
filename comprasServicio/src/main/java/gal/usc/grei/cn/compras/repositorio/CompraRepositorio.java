package gal.usc.grei.cn.compras.repositorio;

import gal.usc.grei.cn.compras.modelo.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompraRepositorio extends MongoRepository<Compra, String> {
/*
    //Compra a partir de simbolo e id
    @Query(value = "{'symbol':  '?0'}")
    public Optional<Compra> findById(String id);

    @Query()
    public Compra insert(Compra compra);
*/
}
