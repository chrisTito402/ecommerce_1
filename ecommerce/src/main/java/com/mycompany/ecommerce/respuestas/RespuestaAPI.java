/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce.respuestas;

/**
 *
 * @author Usuario
 */
public class RespuestaAPI {
    
    public static class SuccessResponse {
        String mensaje;
        public SuccessResponse(String mensaje) { this.mensaje = mensaje; }
    }

    public static class ErrorResponse {
        String error;
        public ErrorResponse(String error) { this.error = error; }
    }
    
    public static class ContadorResponse {
        long cantidad;
        public ContadorResponse(long cantidad) { this.cantidad = cantidad; }
    }
}