package com.aeribmm.moneycounterv4.Service;

import com.aeribmm.moneycounterv4.Model.UserModel;

import java.util.List;
import java.util.Optional;

public interface ServiceMemoryInterface {
    void save(UserModel userModel);
    List<UserModel> findAllFromMemory();

    void addTotal(Long id,Long suma);

    Optional<UserModel> findById(Long id);
    void deleteId(Long id);
}
