package com.aeribmm.moneycounterv4.Service.Impl;

import com.aeribmm.moneycounterv4.DAO.MemoryDAO;
import com.aeribmm.moneycounterv4.Model.UserModel;
import com.aeribmm.moneycounterv4.Service.ServiceMemoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements ServiceMemoryInterface {

    MemoryDAO memory;

    @Override
    public List<UserModel> findAllFromMemory(){
        return memory.findAllFromMemory();
    }

    @Override
    public void save(UserModel userModel){
        memory.save(userModel);
    }

    @Override
    public void addTotal(Long id,Long suma){
        memory.addTotal(id,suma);
    }


    public void addToCategory(Long id,String category, Long cost) {
        memory.addToCategory(id,category,cost);
    }

    @Override
    public Optional<UserModel> findById(Long id){
        return memory.findById(id);
    }
    @Override
    public void deleteId(Long id){
        memory.deleteId(id);
    }

}
