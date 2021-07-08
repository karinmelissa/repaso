package com.davidosorno.repaso.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.davidosorno.repaso.modelos.Dojo;
import com.davidosorno.repaso.modelos.Ninja;
import com.davidosorno.repaso.servicios.DojoService;
import com.davidosorno.repaso.servicios.NinjaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ninjas")
public class NinjaController extends ControladorBase<Ninja> {

    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, HttpSession ninja_session, DojoService dojoService) {
        this.ninjaService = ninjaService;
        session = ninja_session;
        this.dojoService = dojoService;
    }

    @Override
    public String index(Model model) {
        return mostrarPagina(model, "POST");
    }

    @Override
    public String nuevo(@ModelAttribute("ninja") Ninja tabla, Model model) {
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("dojos", dojos);
        return "nuevoNinja";
    }

    @Override
    public String guardar(@Valid @ModelAttribute("ninja") Ninja ninja, Model model, BindingResult resultados) {
        for(ObjectError error : resultados.getAllErrors()){
            System.out.println(error.getDefaultMessage());
        }
        if(resultados.hasErrors()){
            model.addAttribute("method", "POST");
            return "nuevoNinja";
        }
        if(ninjaService.emailExist(ninja.getEmail())){
            FieldError error = new FieldError("email", "email", "El email " + ninja.getEmail() + " ya se encuentra registrado en la base de datos.");
            resultados.addError(error);
            return mostrarPagina(model, "POST");
        } else {
            ninjaService.createOrUpdate(ninja);
            return "redirect:/ninjas";
        }
    }

    @Override
    public String actualizar(Long id, @Valid Ninja tabla, Model model, BindingResult resultados) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String buscarId(Long id, Model model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String editar(Long id, Ninja tabla) {
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
        List<Ninja> ninjas = ninjaService.findAll();
        model.addAttribute("ninjas", ninjas);
        return "ninja";
    }
    
}
