package com.davidosorno.repaso.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.davidosorno.repaso.modelos.Dojo;
import com.davidosorno.repaso.servicios.DojoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dojos")
public class DojoController extends ControladorBase<Dojo> {

    private final DojoService dojoService;

    public DojoController(DojoService dojoService, HttpSession dojo_session) {
        this.dojoService = dojoService;
        session = dojo_session;
    }


    @Override
    public String index(Model model) {
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("dojos", dojos);
        return "dojo";
    }

    @Override
    public String nuevo(@ModelAttribute("dojo") Dojo tabla, Model model) {
        return mostrarPagina(model, "POST");
    }

    @Override
    public String guardar(@Valid @ModelAttribute("dojo") Dojo dojo, Model model, BindingResult resultados) {
        if(resultados.hasErrors()){
            return mostrarPagina(model, "POST");
        }
        dojoService.createOrUpdate(dojo);
        return "redirect:/dojos";
    }

    @Override
    public String actualizar(Long id, @Valid Dojo tabla, Model model, BindingResult resultados) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String buscarId(Long id, Model model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String editar(Long id, Dojo tabla) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String eliminar(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String mostrarPagina(Model model, String metodo) {
        model.addAttribute("method", metodo);
        return "nuevoDojo";
    }
}
