package org.hassen.controller;

import org.hassen.entities.Account;
import org.hassen.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    // methode de chargement de page d'acceuil
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("accounts",accountService.findAll());
        return "index" ;
    }

    // methode de chargement de page d'ajouter nouveau compte
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String saveAccount(ModelMap modelMap){
        modelMap.put("account",new Account());
        return "add" ;
    }

    // methode qui insert dans la base de données
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String saveAccount(@RequestParam(required = false) String username,@RequestParam(required = false) String password,@RequestParam(required = false) String fullName){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setFullName(fullName);
        accountService.save(account);
        return "redirect:/account" ;
    }

    //methode qui supprime de la base de données
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("id") Long id){
        accountService.delete(accountService.find(id));
        return "redirect:/account" ;
    }

    //methode qui modifie le compte
    @RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
    public String editAccount(@PathVariable("id") Long id, ModelMap modelMap){

        modelMap.put("account",accountService.find(id));
        return "edit" ;
    }

    //methode de translation de la page edit vers la page account
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("account") Account account,ModelMap modelMap){
        Account currentAccount = accountService.find(account.getId());
        currentAccount.setFullName(account.getFullName());
        currentAccount.setUsername(account.getUsername());
        if (!account.getPassword().isEmpty()){
            currentAccount.setPassword(account.getPassword());
        }
        accountService.save(currentAccount);
        return "redirect:/account" ;
    }















}
