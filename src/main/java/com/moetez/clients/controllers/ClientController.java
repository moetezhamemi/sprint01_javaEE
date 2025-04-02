package com.moetez.clients.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.moetez.clients.entities.Client;
import com.moetez.clients.service.ClientService;

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
    public String showCreate() {
        return "createClient";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client,
                             @RequestParam("date") String date,
                             ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateInscri = dateformat.parse(String.valueOf(date));
        client.setDateinscription(dateInscri);

        Client saveClient = clientService.saveClient(client);
        String msg = "client enregistré avec Id " + saveClient.getIdclient();
        modelMap.addAttribute("msg", msg);
        return "createClient";
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
                               ModelMap modelMap) {
        Client c = clientService.getClient(id);
        modelMap.addAttribute("client", c);
        return "editerClient";
    }

    @RequestMapping("/updateClient")
    public String updateClient(@ModelAttribute("client") Client client,
                               @RequestParam("date") String date,
                               ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateInscri = dateformat.parse(String.valueOf(date));
        client.setDateinscription(dateInscri);

        clientService.updateClient(client);
        List<Client> clients = clientService.getAllClients();
        modelMap.addAttribute("clients", clients);
        return "listeClients";
    }
}