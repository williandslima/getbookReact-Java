package com.devgetbook.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devgetbook.model.DevUsuario;
import com.devgetbook.repository.DevUsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private DevUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

		Optional<DevUsuario> recebUsuario = usuarioRepository.findByUsuario(usuario);

		if (recebUsuario.isPresent())
			return new UserDetailsImpl(recebUsuario.get());
		else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);

	}
}
