package com.moetez.clients.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moetez.clients.entities.Client;
import com.moetez.clients.entities.Type;
import com.moetez.clients.service.ClientService;

import jakarta.validation.Valid;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;
    @RequestMapping("/ListeClients")
    public String listeClients(ModelMap modelMap ,@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "2") int size)
    		{
    	Page<Client> cls = clientService.getAllClientsParPage(page, size);
    	modelMap.addAttribute("clients", cls);
    	 modelMap.addAttribute("pages", new int[cls.getTotalPages()]);
    	modelMap.addAttribute("currentPage", page);
    	return "listeClients";
    	}
    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
    	List<Type> types = clientService.getAllTypes();
    	modelMap.addAttribute("client",new Client() );
    	modelMap.addAttribute("mode","new" );
    	modelMap.addAttribute("types",types);
        return "formClient";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@Valid  Client client,
    		BindingResult bindingResult,@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size",defaultValue = "2") int size,ModelMap modelMap)
    {
    	int currentPage;
    	boolean isNew = false;
    	if(bindingResult.hasErrors()) {        
    	List<Type> types = clientService.getAllTypes();
        modelMap.addAttribute("types", types);

        modelMap.addAttribute("mode", (client.getIdclient() == null) ? "new" : "edit");
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);

        return "formClient";
        }
    	if (client.getIdclient() == null){ isNew = true;}
    	clientService.saveClient(client);
    	if(isNew)
    	{
    		Page<Client> cls = clientService.getAllClientsParPage(page, size);
    				currentPage = cls.getTotalPages()-1;
    	}
    	else {currentPage = page;}
    	return ("redirect:/ListeClients?page="+currentPage+"&size="+size);
    }
    @RequestMapping("/supprimerClient")
    public String supprimerClient(@RequestParam("id") Long id,
    ModelMap modelMap,
    @RequestParam (name="page",defaultValue = "0") int page,
    @RequestParam (name="size", defaultValue = "2") int size)
    {
    clientService.deleteClientById(id);
    Page<Client> cls = clientService.getAllClientsParPage(page,size);
    modelMap.addAttribute("clients", cls);
    modelMap.addAttribute("pages", new int[cls.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
    modelMap.addAttribute("size", size);
    return "listeClients";
    }

    @RequestMapping("/modifierClient")
    public String editerClient(@RequestParam("id") Long id,
                               ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
                   			@RequestParam (name="size", defaultValue = "2") int size) {
        Client c = clientService.getClient(id);
        List<Type> types = clientService.getAllTypes();
        modelMap.addAttribute("client", c);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("types",types);
        modelMap.addAttribute("size", size);
        modelMap.addAttribute("page", page);
        return "formClient";
    }

	/*
	 * @RequestMapping("/updateClient") public String
	 * updateClient(@ModelAttribute("client") Client client,
	 * 
	 * @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
	 * SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); Date
	 * dateInscri = dateformat.parse(String.valueOf(date));
	 * client.setDateinscription(dateInscri);
	 * 
	 * clientService.updateClient(client); List<Client> clients =
	 * clientService.getAllClients(); modelMap.addAttribute("clients", clients);
	 * return "listeClients"; }
	 */
    @GetMapping (value = "/")
    public String welcome() {
     return "index";
    }


}