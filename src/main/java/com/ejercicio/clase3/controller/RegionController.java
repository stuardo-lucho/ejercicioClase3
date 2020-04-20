package com.ejercicio.clase3.controller;

import com.ejercicio.clase3.repository.RegionRepository;
import com.ejercicio.clase3.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/region")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping(value = {"", "/list"})
    public String listaTerr(Model model) {
        model.addAttribute("listaRegion", regionRepository.findAll());
        return "region/list";
    }
}
