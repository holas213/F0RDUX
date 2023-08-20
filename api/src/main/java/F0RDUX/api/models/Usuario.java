package F0RDUX.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String correo;
    @Getter @Setter
    private String contraseña;
    @Getter @Setter
    private String direccion;
    @Getter @Setter
    private String nroTelefono;

    public Usuario(Long id, String nombre, String correo, String contraseña, String direccion, String nroTelefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.nroTelefono = nroTelefono;
    }
}
