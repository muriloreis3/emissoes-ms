package com.emissor_ms.rest.controller;

import com.emissor_ms.core.entity.UsuarioEntity;
import com.emissor_ms.core.service.JwtService;
import com.emissor_ms.core.service.LoginService;
import com.emissor_ms.rest.dto.LoginDTO;
import com.emissor_ms.rest.dto.LoginResponse;
import com.emissor_ms.rest.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
    private final JwtService jwtService;
    private final LoginService authenticationService;

    public UsuarioController(JwtService jwtService, LoginService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public UsuarioEntity register(@RequestBody UsuarioDTO registerUsuarioEntityDto) {
        UsuarioEntity registeredUsuarioEntity = authenticationService.signup(registerUsuarioEntityDto);

        return registeredUsuarioEntity;
    }

    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody LoginDTO loginUsuarioEntityDto) {
        UsuarioEntity authenticatedUsuarioEntity = authenticationService.authenticate(loginUsuarioEntityDto);

        String jwtToken = jwtService.generateToken(authenticatedUsuarioEntity);

        LoginResponse loginResponse = LoginResponse.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();;

        return loginResponse;
    }

}
