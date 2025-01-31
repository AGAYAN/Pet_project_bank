package com.example.bank_project.Shopping.service.Impl;

import com.example.bank_project.Person.model.UserEntity;
import com.example.bank_project.Person.repository.UserRepository;
import com.example.bank_project.Shopping.dto.ShoppingDto;
import com.example.bank_project.Shopping.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingSeviceImpl implements ShoppingService {
    private final UserRepository userRepository;

    @Override
    public UserEntity buyThing(ShoppingDto shoppingDto) {
        UserEntity userEntity = userRepository.findByNumber(shoppingDto.getNumber())
                .orElseThrow(() -> new RuntimeException("Нету такого user с таким номером"));

        if (userEntity.getBalance() < shoppingDto.getPrice()) {
            throw new RuntimeException("У вас не достаточно средств");
        }
        Long price = userEntity.getBalance() - shoppingDto.getPrice();
        Long wastes = userEntity.getWastes() + shoppingDto.getPrice();

        userEntity.setBalance(price);
        userEntity.setWastes(wastes);

        userRepository.save(userEntity);

        return userEntity;
    }
}
