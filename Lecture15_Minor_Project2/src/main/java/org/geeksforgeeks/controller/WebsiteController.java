package org.geeksforgeeks.controller;

import org.geeksforgeeks.dao.WebSiteRepository;
import org.geeksforgeeks.model.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebsiteController {

    @Autowired
    private WebSiteRepository repository;

    @PreAuthorize("hasAuthority('website_get')")
    @RequestMapping(value="/website", method = RequestMethod.GET)
    public List<Website> listWebsite(){
        return repository.findAll();
    }

    @PreAuthorize("hasAuthority('website_create')")
    @RequestMapping(value = "/website", method = RequestMethod.POST)
    public void createWebsite(@RequestBody Website website){
        repository.save(website);
    }

    @PreAuthorize("hasAuthority('website_delete')")
    @RequestMapping(value = "/website/{id}", method = RequestMethod.DELETE)
    public void deleteWebsite(@PathVariable(value = "id") Integer id){
        repository.delete(id);
    }
}
