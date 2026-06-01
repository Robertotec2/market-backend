package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.crud;


import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
