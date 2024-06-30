package com.aeribmm.moneycounterv4.Service.Impl;

import com.aeribmm.moneycounterv4.DAO.UserRepository;
import com.aeribmm.moneycounterv4.Model.UserModel;
import com.aeribmm.moneycounterv4.Service.ServiceMemoryInterface;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
//
//
// DATA BASE SERVICE
//
//
@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements ServiceMemoryInterface {

    private final UserRepository dbRepository;

    @Override
    public void save(UserModel userModel) {
        dbRepository.save(userModel);
    }

    @Override
    public List<UserModel> findAllFromMemory() {
        return dbRepository.findAll();
    }

    @Override
    public void addTotal(Long id, Long suma) {
        dbRepository.addTotalCost(id,suma);
    }


    @Transactional
    public void addClothes(Long id, Long cost) {
        dbRepository.addClothes(id, cost);
        updateTotalCost(id, cost);
    }


    @Transactional
    public void addFood(Long id, Long cost) {
        dbRepository.addFood(id, cost);
        updateTotalCost(id, cost);
    }


    @Transactional
    public void addFun(Long id, Long cost) {
        dbRepository.addFun(id, cost);
        updateTotalCost(id, cost);
    }

    private void updateTotalCost(Long id, Long cost) {
        UserModel user = dbRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        user.setTotalCost(user.getTotalCost() + cost);
        dbRepository.save(user);
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return dbRepository.findById(id);
    }

    @Override
    public void deleteId(Long id) {
        dbRepository.deleteById(id);
    }
}
