/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce.negocio;

import IPersistencia.IPersistencia;
import entidades.Resenias;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class ReseniasBO {

    private static final Logger LOGGER = Logger.getLogger(ReseniasBO.class.getName());
    private final IPersistencia persistencia;

    public ReseniasBO(IPersistencia persistencia) {
        this.persistencia = persistencia;
    }

    public List<Resenias> consultarResenias() {
        try {
            return persistencia.consultarResenias();
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return null;
        }
    }

    public void eliminarResenia(int id) {
        try {
            persistencia.eliminarResenia(id);
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }
    }

}
