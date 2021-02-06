package com.control.almacen.serviceImplement;

import com.control.almacen.entitys.ReconsiliacionProductos;
import com.control.almacen.repository.ReconsiliacionProductosRepository;
import com.control.almacen.service.ReconsiliacionProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReconsiliacionProductoServicesImpl implements ReconsiliacionProductosService {

    @Autowired
    private ReconsiliacionProductosRepository reconsiliacionRepository;

    @Override
    public ReconsiliacionProductos save(ReconsiliacionProductos reco) {
        return reconsiliacionRepository.save(reco);
    }
}
