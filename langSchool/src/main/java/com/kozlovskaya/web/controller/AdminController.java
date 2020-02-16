package com.kozlovskaya.web.controller;

import com.kozlovskaya.web.entities.Gruppa;
import com.kozlovskaya.web.entities.Lang;
import com.kozlovskaya.web.entities.Message;
import com.kozlovskaya.web.entities.Request;
import com.kozlovskaya.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"answer","messages","message","requests","request"})
public class AdminController {
    @Autowired
    private LangService langService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private GruppaService gruppaService;

    @RequestMapping(value = "/addCourse", method = RequestMethod.GET)
    public String add(Model m) {
        m.addAttribute("newLang", new Lang());
        return "adding";
    }

    @RequestMapping(value = "/man", method = RequestMethod.GET)
    public String man(){
        return "man";
    }

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("newLang") Lang lang) {
        langService.saveOrUpdate(lang);
        return "redirect:/man";
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String requests(Model m){
        m.addAttribute("requests", requestService.findByAcceptFalse());
        return "requests";
    }

    @RequestMapping(value = "/requests/{reqid}",method = RequestMethod.GET)
    public String requests(@PathVariable("reqid") Integer id,Model m) {
        Request request = requestService.findById(id);
        m.addAttribute("request", new RequestBoolean(request, false));
        return "processRequest";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String process(@ModelAttribute("request") RequestBoolean request){
        if (!request.getAccept()) {
            requestService.remove(requestService.findById(request.getRequest().getId()));
            return "redirect:/man";
        } else {
            return "redirect:/groups";
        }
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String groups(Model m){
        m.addAttribute("groups", gruppaService.findAll());
        return "groups";
    }

    @RequestMapping(value = "/groups/{grid}", method = RequestMethod.GET)
    public String addCustomerToGroup(@ModelAttribute("request") RequestBoolean request,
                                     @PathVariable("grid") Integer id){

        Gruppa gruppa = gruppaService.findById(id);
        request.getRequest().setAccept((short) 1);
        System.out.println(request.getRequest().getAccept());
        requestService.saveOrUpdate(request.getRequest());
        gruppa.getCustomerList().add(request.getRequest().getCustomer());

        gruppaService.saveOrUpdate(gruppa);

        return "redirect:/man";
    }




    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String messages(Model m){
        m.addAttribute("messages", messageService.findAllIsNotAccepted());
        return "messages";
    }

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public String sendAnswer(@ModelAttribute("message") Message message,
                             @ModelAttribute("answer") Message answer){
        message.setAccept((short) 1);
        messageService.saveOrUpdate(message);
        answer.setSender(customerService.getAdministrator());
        answer.setTaker(message.getSender());
        messageService.saveOrUpdate(answer);
        return "redirect:/man";
    }

    @RequestMapping(value = "/messages/{mesid}", method = RequestMethod.GET)
    public String answer(@PathVariable("mesid") Integer id, Model m){
        Message message = messageService.findById(id);
        System.out.println(message);
        m.addAttribute("message", message);
        m.addAttribute("answer", new Message());
        return "addContent";
    }



}
