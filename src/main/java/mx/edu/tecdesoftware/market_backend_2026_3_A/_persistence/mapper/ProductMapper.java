package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.mapper;

import mx.edu.tecdesoftware.market_backend_2026_3_A.Domain.Product;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List; // Importación necesaria para las listas

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    public abstract Product toProduct(Producto producto);

    // Mapeo para listas (Soluciona el error en tu repositorio)
    public abstract List<Product> toProducts(List<Producto> productos);

    // Mapeo inverso (Evita que te salga error en el método save() del repositorio)
    @InheritInverseConfiguration
    public abstract Producto toProducto(Product product);
}