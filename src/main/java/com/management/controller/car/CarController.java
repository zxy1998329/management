package com.management.controller.car;

import com.management.entity.Account;
import com.management.entity.Car;
import com.management.mapper.AccountMapper;
import com.management.mapper.CarMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarMapper carMapper;

    @Autowired
    AccountMapper accountMapper;

    //访问列表
    @GetMapping("cars")
    public String list(Model model){
        List<Car> cars = carMapper.findAll();
        model.addAttribute("cars",cars);
        return "car/list";
    }

    //添加页面
    @GetMapping("car")
    public String addPage(Model model){
        List<Account> accounts = accountMapper.findAllUsers();
        model.addAttribute("accounts",accounts);
        return "car/add";
    }

    //添加请求
    @PostMapping("car")
    public String add(Car car){
        car.setDate(new Date());
        carMapper.insertCar(car);
        return "redirect:/cars";
    }

    //修改页面
    @GetMapping("car/{id}")
    public String editPage(@PathVariable("id")Integer id, Model model){
        Car car = carMapper.findCarById(id);
        model.addAttribute("car",car);
        return "car/add";
    }

    //修改请求
    @PutMapping("car")
    public String edit(Car car){
        carMapper.updateCar(car);
        return "redirect:/cars";
    }

    //删除请求
    @DeleteMapping("/car/{id}")
    public String delete(@PathVariable("id") Integer id){
        carMapper.deleteCarById(id);
        return "redirect:/cars";
    }

    //业主查看自己车辆,id是业主id
    @GetMapping("/myCar/{id}")
    public String myCarList(@PathVariable("id") Integer id, Model model){
        Account account = accountMapper.getAccountById(id);
        String userName = account.getUserName();
        List<Car> cars = carMapper.findCarsByOwnerUserName(userName);
        model.addAttribute("cars",cars);
        return "car/list";
    }
}
