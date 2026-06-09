package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_A.Domain.Product;
import mx.edu.tecdesoftware.market_backend_2026_3_A.Domain.repository.ProductRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Producto;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private final ProductoCrudRepository productoCrudRepository;
    private final ProductMapper productMapper;

    // Constructor para la Inyección de Dependencias de Spring
    public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductMapper productMapper) {
        this.productoCrudRepository = productoCrudRepository;
        this.productMapper = productMapper;
    }

    // SELECT * FROM productos
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    // Se unificó la lógica aquí (nombre correcto de la interfaz)
    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return Optional.of(productMapper.toProducts(productos.get()));
    }

    // Se unificó la lógica aquí (nombre correcto de la interfaz)
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}