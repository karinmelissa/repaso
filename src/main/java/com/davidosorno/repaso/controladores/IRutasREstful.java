package com.davidosorno.repaso.controladores;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface IRutasREstful<T> {

    // #     https://www.mysite.com/users                # GET returns a collection of all users.
    @GetMapping("")
    String index(Model model);


    // #     https://www.mysite.com/users/new            # GET returns form to create a new user.
    @GetMapping("nuevo")
    String nuevo(@ModelAttribute("T") T tabla, Model model);


    // #     https://www.mysite.com/users/new            # POST save the user to the DB.
    @PostMapping("nuevo")
    String guardar(@Valid @ModelAttribute("T") T tabla, Model model, BindingResult resultados);


    // #     https://www.mysite.com/users/<id>           # GET returns a single user.
    @GetMapping("{id}")
    String buscarId(@PathVariable("id") Long id, Model model);


    // #     https://www.mysite.com/users/<id>/edit      # GET returns for to edit the current user information.
    @GetMapping("{id}/editar")
    String editar(@PathVariable("id") Long id, @ModelAttribute("T") T tabla);


    // #     https://www.mysite.com/users/<id>/edit      # POST save changes to the DB and redirect to the main page.
    @PutMapping("{id}/editar")
    String actualizar(@PathVariable("id") Long id, @Valid @ModelAttribute("T") T tabla, Model model, BindingResult resultados);


    // #     https://www.mysite.com/users/<id>/delete    # GET remove the user with de ID from DB.
    @GetMapping("{id}/eliminar")
    String eliminar(@PathVariable("id") Long id);

    // @DeleteMapping("{id}/eliminar")
    // String eliminarDeleteMapping(@PathVariable("id") Long id);

    String mostrarPagina(Model model, String metodo);
    
}