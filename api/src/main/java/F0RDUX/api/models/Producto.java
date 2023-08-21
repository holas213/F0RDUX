package F0RDUX.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    Long Id;
    @Getter
    @Setter
    String Nombre;
    @Getter
    @Setter
    String Descripcion;
    @Getter
    @Setter
    Double Precio;
    @Enumerated(EnumType.STRING)
    @Column(name= "CategoriaProducto")
    @Getter
    @Setter
    CategoriaProducto CategoriaProducto;
    @Getter
    @Setter
    Long Stock;
    @Getter
    @Setter
    String DireccionImagen;
    public Producto(){}
    public Producto(Long id, String nombre, String descripcion, Double precio, F0RDUX.api.models.CategoriaProducto categoriaProducto, Long stock, String direccionImagen) {
        Id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        Precio = precio;
        CategoriaProducto = categoriaProducto;
        Stock = stock;
        DireccionImagen = direccionImagen;
    }
}
