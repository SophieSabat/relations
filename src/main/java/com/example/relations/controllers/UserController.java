package com.example.relations.controllers;

import com.example.relations.dao.UserDao;
import com.example.relations.models.Car;
import com.example.relations.models.Product;
import com.example.relations.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserDao userDao;

    @GetMapping()
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @GetMapping("/save")
    public void save() {
        User user = new User();
        user.setName("vasya");

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("milk"));
        productList.add(new Product("kokos"));
        user.setProducts(productList);

        userDao.save(user);
    }

    @GetMapping("/userWithCars")
    public void userWithCars() {
        User user = new User("max");
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("mazda"));
        cars.add(new Car("suba"));
        user.setCars(cars);

        userDao.save(user);
    }
}
