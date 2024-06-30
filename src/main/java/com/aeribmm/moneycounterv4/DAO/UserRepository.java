package com.aeribmm.moneycounterv4.DAO;

import com.aeribmm.moneycounterv4.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE UserModel u SET u.clothes = u.clothes + :cost WHERE u.id = :id")
    void addClothes(Long id, Long cost);

    @Transactional
    @Modifying
    @Query("UPDATE UserModel u SET u.food = u.food + :cost WHERE u.id = :id")
    void addFood(Long id, Long cost);

    @Transactional
    @Modifying
    @Query("UPDATE UserModel u SET u.fun = u.fun + :cost WHERE u.id = :id")
    void addFun(Long id, Long cost);

    @Transactional
    @Modifying
    @Query("UPDATE UserModel u SET u.totalCost = u.totalCost + :cost WHERE u.id = :id")
    void addTotalCost(Long id, Long cost);



}
