package com.management.mapper;

import com.management.entity.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarMapper {
    @Select("select car.*,account.realName AS ownerRealName " +
            "from car,account " +
            "where car.ownerUserName = account.userName " +
            "order by date DESC")
    public List<Car> findAll();

    @Select("select * from car where id=#{id} order by date DESC")
    public Car findCarById(Integer id);

    @Select("select * from car where ownerUserName=#{ownerUserName} order by date DESC")
    public List<Car> findCarsByOwnerUserName(String ownerUserName);

    @Insert("insert into car(ownerUserName, license, brand, color, date) " +
            "values(#{ownerUserName}, #{license}, #{brand}, #{color}, #{date})")
    public void insertCar(Car car);

    @Update("update car set " +
            "license=#{license}, brand=#{brand}, color=#{color} " +
            "where id = #{id}")
    public void updateCar(Car car);

    @Delete("delete from car where id = #{id}")
    public void deleteCarById(Integer id);
}