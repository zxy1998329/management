package com.management.mapper;

import com.management.entity.Pay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PayMapper {
    @Select("select * from pay where id=#{id}")
    public Pay getPayById(Integer id);

    @Update("update pay set " +
            "water=#{water},electric=#{electric},gas=#{gas},manage=#{manage} " +
            "where id = #{id}")
    public void updatePay(Pay pay);

    @Insert("insert into pay(id,water,electric,gas,manage) " +
            "values(#{id},#{water},#{electric},#{gas},#{manage})")
    public void insertPay(Pay pay);
}
