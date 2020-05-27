package com.management.controller.car;

import com.alibaba.druid.mock.MockArray;
import com.management.entity.Car;
import com.management.entity.CarRequest;
import com.management.mapper.CarMapper;
import com.management.mapper.CarRequestMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CarRequestController {
    @Autowired
    CarRequestMapper carRequestMapper;

    @Autowired
    CarMapper carMapper;

    //添加页面
    @GetMapping("carRequest")
    public String addPage(){
        return "car/carRequest/add";
    }

    //添加请求
    @PostMapping("carRequest")
    public String add(CarRequest carRequest, HttpSession session){
        carRequest.setOwnerUserName((String)session.getAttribute("userName") );
        carRequest.setDate(new Date());
        carRequest.setState(0);
        carRequestMapper.insertCarRequest(carRequest);
        return "redirect:/myCar/" + ((Integer)session.getAttribute("id")).toString();
    }

    //查看某一个用户的页面
    @GetMapping("carRequest/{ownerUserName}")
    public String listOnePage(@PathVariable("ownerUserName")String ownerUserName, Model model){
        List<CarRequest> carRequests = carRequestMapper.findCarRequestByOwnerUserName(ownerUserName);
        model.addAttribute("carRequests",carRequests);
        return "car/carRequest/list";
    }

    //删除请求
    @DeleteMapping("carRequest/{id}")
    public String delete(@PathVariable("id")Integer id,HttpSession session){
        carRequestMapper.deleteById(id);
        return "redirect:/carRequest/" + (String )session.getAttribute("userName");
    }

    //查看所有页面
    @GetMapping("carRequests")
    public String allPage(Model model){
        List<CarRequest> carRequests = carRequestMapper.findAll();
        model.addAttribute("carRequests",carRequests);
        return "car/carRequest/list";
    }

    //同意审核
    @PutMapping("carRequest_yes/{id}")
    public String yes(@PathVariable("id")Integer id){
        //状态变成通过
        carRequestMapper.updateYesById(id);
        //把车辆添加到数据库中
        CarRequest carRequest = carRequestMapper.findCarRequestById(id);
        Car car = new Car();
        car.setOwnerUserName(carRequest.getOwnerUserName());
        car.setLicense(carRequest.getLicense());
        car.setBrand(carRequest.getBrand());
        car.setColor(carRequest.getColor());
        car.setDate(new Date());
        System.out.println(carRequest);
        System.out.println(car);
        carMapper.insertCar(car);
        return "redirect:/carRequests";
    }

    //不同意审核
    @PutMapping("carRequest_no/{id}")
    public String no(@PathVariable("id")Integer id){
        carRequestMapper.updateNoById(id);
        return "redirect:/carRequests";
    }
}
