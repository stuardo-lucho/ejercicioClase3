package com.ejercicio.clase3.controller;

import com.ejercicio.clase3.entity.Territory;
import com.ejercicio.clase3.repository.RegionRepository;
import com.ejercicio.clase3.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/territory")
public class TerritoryController {

    @Autowired
    TerritoryRepository territoryRepository;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping(value = {"", "/list"})
    public String listaTerr(Model model) {
        model.addAttribute("listaTerri", territoryRepository.findAll());
        model.addAttribute("listaRegions", regionRepository.findAll());
        return "territory/list";
    }

    @GetMapping(value = "/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("listaRegions", regionRepository.findAll());
        return "territory/newForm";
    }

    @PostMapping(value = "/guardar")
    public String guardarTerr(Territory t, RedirectAttributes attr) {
        if (t.getId() != null) {
            Optional<Territory> opt = territoryRepository.findById(t.getId());
            territoryRepository.save(t);
            attr.addFlashAttribute("msg", "Territorio " + (opt.isPresent() ? "actualizado" : "creado") + " exitosamente");
        }
        return "redirect:/territory";
    }

    @GetMapping(value = "/editar")
    public String editForm(Model model,
                           @RequestParam("id") String id) {
        Optional<Territory> opt = territoryRepository.findById(id);
        if (opt.isPresent()) {
            model.addAttribute("territory", opt.get());
            model.addAttribute("listaRegions", regionRepository.findAll());
            return "territory/editForm";
        } else {
            return "redirect:/territory";
        }

    }

    @GetMapping(value = "/delete")
    public String borrar(@RequestParam("id") String id, RedirectAttributes attr) {
        Optional<Territory> opt = territoryRepository.findById(id);
        if (opt.isPresent()) {
            territoryRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Territorio borrado exitosamente");
        }
        return "redirect:/territory";

    }

}
