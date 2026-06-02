package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    //SELECT * productos
    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional <Producto> getProductoById(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}