package com.viegas.smartattence.api.utils;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordUtilsTest {

    private static final String PASSWORD = "123456";
    private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

    @Test
    public void testSenhaNula() throws Exception {
        assertNull(PasswordUtils.gerarBCrypt(null));
    }
    
    @Test
    public void testGerarHashSenha() throws Exception {
        String hash = PasswordUtils.gerarBCrypt(PASSWORD);
        
        assertTrue(bCryptEncoder.matches(PASSWORD, hash));
    }
}