package com.emissor_ms.core.service.impl;

import com.emissor_ms.core.entity.UsuarioEntity;
import com.emissor_ms.core.mapper.UsuarioMapper;
import com.emissor_ms.core.repository.UsuarioRepository;
import com.emissor_ms.core.service.LoginService;
import com.emissor_ms.rest.dto.LoginDTO;
import com.emissor_ms.rest.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public LoginServiceImpl(UsuarioRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public UsuarioEntity signup(UsuarioDTO input) {
        input.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(usuarioMapper.dtoToEntity(input));
    }

    public UsuarioEntity authenticate(LoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}
