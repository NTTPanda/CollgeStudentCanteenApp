package com.example.CanteenCollegeApp.Service;

import com.example.CanteenCollegeApp.dto.request.MenuRequest;
import com.example.CanteenCollegeApp.model.MenuTable;
import com.example.CanteenCollegeApp.repository.MenuRepository;
import com.example.CanteenCollegeApp.transformer.MenuTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public String addNewFoodItem(MenuRequest menuRequest) {
        MenuTable menuTable = MenuTransformer.menuRequestToMenuTable(menuRequest);
        menuRepository.save(menuTable);
        return "Food item added successfully!";
    }

    public String updateFoodItem(int id, MenuRequest menuRequest) {
        Optional<MenuTable> optionalMenu = menuRepository.findById(id);
        if (optionalMenu.isPresent()) {
            MenuTable existingMenu = optionalMenu.get();

            // Update all relevant fields
            existingMenu.setFoodItemName(menuRequest.getFoodItemName());
            existingMenu.setPrice(menuRequest.getPrice());
            existingMenu.setQuantity(menuRequest.getQuantity());
            existingMenu.setCategory(menuRequest.getCategory());

            // Save the updated menu item
            menuRepository.save(existingMenu);
            return "Food item updated successfully!";
        } else {
            return "Food item not found!";
        }
    }
    public String deleteFoodItem(int id) {
        Optional<MenuTable> optionalMenu = menuRepository.findById(id);
        if (optionalMenu.isPresent()) {
            menuRepository.deleteById(id);
            return "Food item deleted successfully!";
        } else {
            return "Food item not found!";
        }
    }

    public List<MenuTable> getAllMenuItems() {
        return menuRepository.findAll();
    }

    public String updateQuntity(String foodItemName ,int quntity) {
        MenuTable foodname=menuRepository.findByFoodItemName(foodItemName);
        if (foodname == null) {
            return "Food item not found: " + foodItemName;
        }

        if (foodname.getQuantity() <= 0) {
            return "Quantity already zero for item: " + foodItemName;
        }
        foodname.setQuantity(foodname.getQuantity()-quntity);
        menuRepository.save(foodname);
        return "Quantity reduced successfully for " + foodItemName + ". Remaining: " + foodname.getQuantity();
    }

}
