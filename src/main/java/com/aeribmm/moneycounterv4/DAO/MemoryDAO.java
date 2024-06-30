package com.aeribmm.moneycounterv4.DAO;

import com.aeribmm.moneycounterv4.Model.UserModel;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryDAO {
    private final List<UserModel> list = new ArrayList<>();

    public List<UserModel> findAllFromMemory(){
        return list;
    }
    public void save(UserModel userModel){
        list.add(userModel);
    }

    public void addTotal(Long id,Long suma){
        list.stream().
                filter(userModel -> userModel.getId().equals(id)).
                findFirst().
                ifPresent(userModel -> userModel.setTotalCost(userModel.getTotalCost() + suma));
    }
    public void addToCategory(Long id, String category,Long cost){
        String categoryLower = category.toLowerCase();
        int index = id.intValue();
            switch(categoryLower){
                case "clothes":
                    list.get(index - 1).setClothes(list.get(index - 1).getClothes() + cost);
                    addTotal(id,cost);
                    break;
                case "food":
                    list.get(index - 1).setFood(list.get(index - 1).getFood() + cost);
                    addTotal(id,cost);
                    break;
                case "fun":
                    list.get(index - 1).setFun(list.get(index - 1).getFun() + cost);
                    addTotal(id,cost);
                    break;
                default:
            }
    }

    public Optional<UserModel> findById(Long id) {
        return list.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void deleteId(Long id){
        list.stream().
                filter(user -> user.getId().equals(id)).
                findFirst().
                ifPresent(user -> list.remove(user));
    }
}
