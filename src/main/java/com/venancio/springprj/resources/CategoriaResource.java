package com.venancio.springprj.resources;

import com.venancio.springprj.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar(){

        Categoria cat1 = new Categoria(1,"Test");
        Categoria cat2 = new Categoria(2,"Dev");

        List<Categoria> listCAtegorias = new ArrayList<>();

        listCAtegorias.add(cat1);
        listCAtegorias.add(cat2);

        return listCAtegorias;
    }

}
