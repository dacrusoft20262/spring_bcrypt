package co.edu.usco.pw.spring_bcrypt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.usco.pw.spring_bcrypt.model.Usuario;
import co.edu.usco.pw.spring_bcrypt.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Usuario saveUsuario(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // encriptación
		return usuarioRepository.save(usuario);
	}

}