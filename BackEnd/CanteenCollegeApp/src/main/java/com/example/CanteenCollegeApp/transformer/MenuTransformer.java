package com.example.CanteenCollegeApp.transformer;


import com.example.CanteenCollegeApp.dto.request.MenuRequest;
import com.example.CanteenCollegeApp.model.MenuTable;

public class MenuTransformer {
    public static MenuTable menuRequestToMenuTable(MenuRequest menuRequest) {
        MenuTable menuTable=new MenuTable();
        menuTable.setCategory(menuRequest.getCategory());
        menuTable.setPrice(menuRequest.getPrice());
        menuTable.setQuantity(menuRequest.getQuantity());
        menuTable.setFoodItemName(menuRequest.getFoodItemName());
        return  menuTable;
    }
}
