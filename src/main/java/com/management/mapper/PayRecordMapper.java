package com.management.mapper;

import com.management.entity.Pay;
import com.management.entity.PayRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PayRecordMapper {
    @Insert("insert into payRecord(id,ownerId,ownerUserName,type,money,date) " +
            "values(#{id},#{ownerId},#{ownerUserName},#{type},#{money},#{date})")
    public void insertPayRecord(PayRecord payRecord);

    @Select("select * from payRecord where ownerId=#{ownerId} order by date DESC")
    public List<PayRecord> findPayRecordByOwnerId(Integer ownerId);

    @Select("select * from payRecord order by date DESC")
    public List<PayRecord> findAll();
}
