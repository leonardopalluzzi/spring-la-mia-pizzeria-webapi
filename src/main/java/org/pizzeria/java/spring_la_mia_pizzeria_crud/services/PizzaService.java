package org.pizzeria.java.spring_la_mia_pizzeria_crud.services;

import java.util.List;

import org.pizzeria.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.pizzeria.java.spring_la_mia_pizzeria_crud.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepo;

    public List<Pizza> findAll() {
        return pizzaRepo.findAll();
    }

    public List<Pizza> findAllByTitle(Pageable pagination, String title) {
        Page pizzaList = pizzaRepo.findAllByNameContaining(pagination, title);

        return pizzaList.toList();
    }

}
