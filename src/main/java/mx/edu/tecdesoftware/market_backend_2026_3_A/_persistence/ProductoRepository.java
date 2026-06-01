package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    //SELECT * productos
    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
