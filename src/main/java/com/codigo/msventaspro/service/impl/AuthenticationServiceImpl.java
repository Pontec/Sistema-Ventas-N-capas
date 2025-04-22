package com.codigo.msventaspro.service.impl;

import com.codigo.msventaspro.aggregates.request.SignInRequest;
import com.codigo.msventaspro.aggregates.request.SignUpRequest;
import com.codigo.msventaspro.aggregates.response.AuthenticationResponse;
import com.codigo.msventaspro.dao.RolRepository;
import com.codigo.msventaspro.dao.UsuarioRepository;
import com.codigo.msventaspro.entities.Rol;
import com.codigo.msventaspro.entities.Role;
import com.codigo.msventaspro.entities.Usuario;
import com.codigo.msventaspro.service.AuthenticationService;
import com.codigo.msventaspro.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Transactional
    @Override
    public Usuario signUpUser(SignUpRequest signUpRequest) {
        return crearUsuario(signUpRequest, Set.of(Role.USER));
    }

    @Transactional
    @Override
    public Usuario signUpAdmin(SignUpRequest signUpRequest) {
        return crearUsuario(signUpRequest, Set.of(Role.ADMIN, Role.USER));
    }

    @Override
    public List<Usuario> todos() {
        return usuarioRepository.findAll();
    }

    @Override
    public AuthenticationResponse signin(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(),signInRequest.getPassword()));
        var user = usuarioRepository.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email no valido"));

        var token = jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(token);
        return authenticationResponse;
    }

    //Metodos de apoyo
    private Rol obtenerOCrearRol(Role roleType) {
        return rolRepository.findByNombreRol(roleType.name())
                .orElseGet(() -> {
                    Rol nuevoRol = new Rol(roleType.name());
                    return rolRepository.save(nuevoRol);
                });
    }

    private Usuario crearUsuario(SignUpRequest request, Set<Role> roles) {
        Usuario usuario = new Usuario();
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());
        usuario.setEmail(request.getEmail());
        usuario.setTipoDoc(request.getTipoDoc());
        usuario.setNumDoc(request.getNumDoc());
        usuario.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));

        Set<Rol> rolesAsignados = roles.stream()
                .map(this::obtenerOCrearRol)
                .collect(Collectors.toSet());
        usuario.setRoles(rolesAsignados);

        return usuarioRepository.save(usuario);
    }
}
