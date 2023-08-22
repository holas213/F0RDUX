package F0RDUX.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    Long Id;
    @Getter
    @Setter
    Long IdUsuario;
    @Getter
    @Setter
    List<Producto> Productos;
    @Getter
    @Setter
    Double Total;
    public Carrito(){}
    public Carrito(Long id, Long idUsuario, List<Producto> productos, Double total) {
        Id = id;
        IdUsuario = idUsuario;
        Productos = productos;
        Total = total;
    }
}
