package F0RDUX.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    Long Id;
    @Getter
    @Setter
    List<Long> ListaProductos;
    @Getter
    @Setter
    Long IdUsuario;
    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    EstadoPedido Estado;
    @Getter
    @Setter
    Double Total;
}
