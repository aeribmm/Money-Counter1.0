package com.aeribmm.moneycounterv4.Controller;


import com.aeribmm.moneycounterv4.Model.UserModel;
import com.aeribmm.moneycounterv4.Service.Impl.UserService;
import com.aeribmm.moneycounterv4.Service.Impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class MainController {

    UserService service;

    UserServiceImpl serviceDB;

    @GetMapping("/findAll")
    public List<UserModel> findAllUsers(){
        return serviceDB.findAllFromMemory();
    }

    @PostMapping("/create/user")
    public void create(@RequestBody UserModel userModel){
        serviceDB.save(userModel);
    }

    @PatchMapping("/add/{id}/{suma}")
    public void addTotal(@PathVariable Long id,@PathVariable Long suma){
        serviceDB.addTotal(id,suma);
    }
    @PatchMapping("/add/{id}/{category}/{cost}")
    public String addToCategory(@PathVariable Long id,@PathVariable String category, @PathVariable Long cost){
        String lower = category.toLowerCase();
        switch (lower){
            case"fun":
                serviceDB.addFun(id,cost);
                break;
            case"food":
                serviceDB.addFood(id,cost);
                break;
            case"clothes":
                serviceDB.addClothes(id,cost);
                break;
            default:
        }
        return "Success";
    }
    @GetMapping("/findbyid/{id}")
    public Optional<UserModel> findById(@PathVariable Long id){
        return serviceDB.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteId(@PathVariable Long id){
        serviceDB.deleteId(id);
    }


}
