package com.interview.java25.nivel03_avanzado.p02_criptografia;

import java.util.Arrays;
import java.util.HexFormat;
import javax.crypto.KDF;
import javax.crypto.spec.HKDFParameterSpec;

// JEP 510: KDF definitiva en Java 25. Vector público RFC 5869, caso 1; datos de prueba.
class KeyDerivationLab {
    byte[] derive(byte[] input, byte[] salt, byte[] info, int length) throws Exception {
        var spec = HKDFParameterSpec.ofExtract().addIKM(input).addSalt(salt).thenExpand(info, length);
        return KDF.getInstance("HKDF-SHA256").deriveData(spec);
    }

    void main() throws Exception {
        var hex = HexFormat.of();
        byte[] input = new byte[22];
        Arrays.fill(input, (byte) 0x0b);
        byte[] salt = hex.parseHex("000102030405060708090a0b0c");
        byte[] info = hex.parseHex("f0f1f2f3f4f5f6f7f8f9");
        byte[] expected = hex.parseHex(
            "3cb25f25faacd57a90434f64d0362f2a2d2d0a90cf1a5a4c5db02d56ecc4c5bf34007208d5b887185865");
        byte[] actual = derive(input, salt, info, 42);
        if (!Arrays.equals(expected, actual)) throw new AssertionError("No coincide con RFC 5869");
        if (!Arrays.equals(actual, derive(input, salt, info, 42))) throw new AssertionError("Determinismo");
        if (Arrays.equals(actual, derive(input, salt, new byte[] {1}, 42))) {
            throw new AssertionError("info debe separar contextos de derivación");
        }
        System.out.println("OK: HKDF-SHA256 validado con un vector público de 42 bytes");
    }
}
