package org.example.test;

import org.example.Datos.DatosUsuariosYAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatosUsuariosYAdminTest {

    @Test
    void buscarUsuarioyClave() {
        String usuarioBuscado = "lian";
        String claveBuscada = "1313";
        assertTrue(DatosUsuariosYAdmin.buscarUsuarioyClave(usuarioBuscado,claveBuscada));
    }

    @Test
    void buscarUsuarioOAdmin() {
        String usuarioBuscado = "admin";
        String claveBuscada = "1234";
        assertTrue(DatosUsuariosYAdmin.buscarUsuarioOAdmin(usuarioBuscado,claveBuscada));
    }
}