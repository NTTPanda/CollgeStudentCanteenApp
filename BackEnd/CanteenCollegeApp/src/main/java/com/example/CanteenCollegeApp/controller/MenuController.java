//package com.example.Canteen.Management.App.controller;
//
//
//import com.example.Canteen.Management.App.dto.request.MenuRequest;
//import com.example.Canteen.Management.App.service.MenuService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@RestController
//@RequestMapping("/menutable")
//public class MenuController {
//
//    @Autowired
//    MenuService menuService;
//
//    @PostMapping("/add")
//    public String addNewFoodItem(@RequestBody MenuRequest menuRequest){
//        return menuService.addNewFoodItem(menuRequest);
//    }
//
//    @PutMapping("/update/{id}")
//    public String updateFoodItem(@PathVariable Long id, @RequestBody MenuRequest menuRequest) {
//        return menuService.updateFoodItem(id, menuRequest);
//    }
//
//}


package com.example.CanteenCollegeApp.controller;


import com.example.CanteenCollegeApp.dto.request.MenuRequest;
import com.example.CanteenCollegeApp.model.MenuTable;
import com.example.CanteenCollegeApp.Service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menutable")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/add")
    public String addNewFoodItem(@RequestBody MenuRequest menuRequest){
        return menuService.addNewFoodItem(menuRequest);
    }

    @GetMapping("/all")
    public List<MenuTable> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    @PutMapping("/update/{id}")
    public String updateFoodItem(@PathVariable int id, @RequestBody MenuRequest menuRequest) {
        return menuService.updateFoodItem(id, menuRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFoodItem(@PathVariable int id) {
        return menuService.deleteFoodItem(id);
    }

    @PutMapping("/reduceQuntity/{foodItemName}/{quntity}")
    public  String updateQuntity(@PathVariable String foodItemName,@PathVariable int quntity){
        return menuService.updateQuntity(foodItemName,quntity);
    }
}

