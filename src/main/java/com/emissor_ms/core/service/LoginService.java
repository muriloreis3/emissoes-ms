package com.emissor_ms.core.service;


import com.emissor_ms.core.entity.UsuarioEntity;
import com.emissor_ms.rest.dto.LoginDTO;
import com.emissor_ms.rest.dto.UsuarioDTO;

public interface LoginService {
    UsuarioEntity signup(UsuarioDTO usuarioDTO);
    UsuarioEntity authenticate(LoginDTO loginDTO);
}
