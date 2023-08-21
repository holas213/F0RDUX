package F0RDUX.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long Id;
    @Getter @Setter
    private String Nombre;
    @Getter @Setter @Column(unique = true)
    private String Correo;
    @Getter @Setter
    private String Contraseña;
    @Getter @Setter
    private String Pais;
    @Getter @Setter
    private String NroTelefono;

    public Usuario(){}
    public Usuario(Long id, String nombre, String correo, String contraseña, String pais, String nroTelefono) {
        this.Id = id;
        this.Nombre = nombre;
        this.Correo = correo;
        this.Contraseña = contraseña;
        this.Pais = pais;
        this.NroTelefono = nroTelefono;
    }
}
