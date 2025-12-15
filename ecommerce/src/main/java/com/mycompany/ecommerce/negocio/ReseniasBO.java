/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce.negocio;

import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.ReseniaDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.mappers.ProductoMapper;
import com.mycompany.ecommerce.mappers.ReseniaMapper;
import com.mycompany.ecommerce.mappers.UsuarioMapper;
import entidades.Resenia;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class ReseniasBO {

    private static final Logger LOGGER = Logger.getLogger(ReseniasBO.class.getName());
    UsuarioMapper usuarioMapper = new UsuarioMapper();
    ProductoMapper productoMapper = new ProductoMapper();
    ReseniaMapper reseniaMapper = new ReseniaMapper();
    
    private final IPersistencia persistencia;

    public ReseniasBO(IPersistencia persistencia) {
        this.persistencia = persistencia;
    }
    
    public ReseniaDTO agregarResenia(ReseniaDTO reseniaDTO){
        Resenia resenia = reseniaMapper.toEntity(reseniaDTO);
        Resenia reseniaRegistrada = persistencia.agregarResenia(resenia);
        return reseniaMapper.toDTO(reseniaRegistrada);
    }

    public List<ReseniaDTO> consultarReseniasPorProducto(int idProducto){
        try {
            List<Resenia> listaResenias = persistencia.consultarReseniasDeProducto(idProducto);
            List<ReseniaDTO> listaReseniasDTO = new ArrayList<>();
            
            for (Resenia resenia : listaResenias) {
                ReseniaDTO reseniaDTO = reseniaMapper.toDTO(resenia);
                listaReseniasDTO.add(reseniaDTO);
            }
            
            return listaReseniasDTO;
            
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return null;
        }
    }
    
    public List<ReseniaDTO> consultarResenias() {
        try {
            List<Resenia> resenia = persistencia.consultarResenias();
            List<ReseniaDTO> reseniasDTO = new ArrayList<>();
            
            for (Resenia r : resenia){
                reseniasDTO.add(reseniaMapper.toDTO(r));
            }
            return reseniasDTO;
            
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
