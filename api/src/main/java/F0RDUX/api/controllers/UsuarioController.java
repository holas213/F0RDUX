package F0RDUX.api.controllers;

import F0RDUX.api.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.web.bind.annotation.*;
import F0RDUX.api.repositories.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api", method = { RequestMethod.GET, RequestMethod.POST })
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository=usuarioRepository;
    }

    @PostMapping("/verificar/{correo}/{contraseña}")
    public Boolean verificarUsuario(@PathVariable String correo,@PathVariable String contraseña)
    {
        for(Usuario usuario:usuarioRepository.findAll())
        {
            if(usuario.getCorreo().equals(correo) && Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i)
                    .verify(usuario.getContraseña(), contraseña))
            {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAll()
    {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios/create")
    public Usuario create(Usuario usuario)
    {
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        String contraseñaCriptada=argon2.hash(5,1024,1,usuario.getContraseña());
        usuario.setContraseña(contraseñaCriptada);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @DeleteMapping("/usuarios/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        usuarioRepository.deleteById(id);
    }
    @DeleteMapping("/usuarios/deleteAll")
    public void deleteAll()
    {
        usuarioRepository.deleteAll();
    }
}
