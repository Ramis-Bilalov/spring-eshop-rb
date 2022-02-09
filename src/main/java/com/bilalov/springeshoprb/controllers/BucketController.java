package com.bilalov.springeshoprb.controllers;

import com.bilalov.springeshoprb.database.DatabaseConnect;
import com.bilalov.springeshoprb.database.DatabaseService;
import com.bilalov.springeshoprb.dto.BucketDTO;
import com.bilalov.springeshoprb.service.BucketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;

@Controller
public class BucketController {

    private final BucketService bucketService;
    private final DatabaseConnect db;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
//        DatabaseService databaseService = new DatabaseService();
        db = new DatabaseConnect();
    }

    @GetMapping("/bucket")
    public String aboutBucket(Model model, Principal principal){
        if(principal == null){
            model.addAttribute("bucket", new BucketDTO());
        }
        else {
            BucketDTO bucketDto = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket", bucketDto);
        }

        return "bucket";
    }

    @PostMapping("/bucket")
    public String commitBucket(Principal principal){
        if(principal != null){
            bucketService.commitBucketToOrder(principal.getName());
        }
        return "redirect:/bucket";
    }

    @GetMapping("/remove/{title}")
    public String removeProductFromBucket(@PathVariable String title, Principal principal) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        db.removeFromBucket(title, principal.getName());
        return "redirect:/bucket";
    }
}