package com.management.mapper;

import com.management.entity.Car;
import com.management.entity.CarRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarRequestMapper {
    @Insert("insert into carRequest(ownerUserName, license, brand, color, date, state) " +
            "values(#{ownerUserName}, #{license}, #{brand}, #{color}, #{date}, #{state})")
    public void insertCarRequest(CarRequest carRequest);

    @Select("select * from carRequest where ownerUserName=#{ownerUserName} order by date DESC")
    public List<CarRequest> findCarRequestByOwnerUserName(String ownerUserName);

    @Select("select c.*,a.RealName AS ownerRealName from " +
            "carRequest AS c,account AS a " +
            "where c.ownerUserName=a.userName " +
            "order by date DESC")
    public List<CarRequest> findAll();

    @Select("select * from carRequest where id = #{id} order by date DESC")
    public CarRequest findCarRequestById(Integer id);

    @Delete("delete from carRequest where id = #{id}")
    public void deleteById(Integer id);

    @Update("update carRequest set " +
            "state = 1 " +
            "where id = #{id}")
    public void updateYesById(Integer id);

    @Update("update carRequest set " +
            "state = -1 " +
            "where id = #{id}")
    public void updateNoById(Integer id);
}
