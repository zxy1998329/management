package com.management.mapper;

import com.management.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AccountMapper {
    @Select("select * from account where id=#{id}")
    public Account getAccountById(Integer id);

    @Select("select * from account where userName=#{userName}")
    public Account getAccountByUsername(String userName);

    @Select("select passWord from account where id = #{id}")
    public String getPasswordById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into account(realName,nickName,userName,passWord,address,vip)" +
            "  values(#{realName},#{nickName},#{userName},#{passWord},#{address},#{vip})")
    public void insertAccount(Account account);

    @Delete("delete from account where id=#{id}")
    public void deleteAccountById(Integer id);

    @Update("update account set " +
           "realName = #{realName},nickName=#{nickName},userName=#{userName},address=#{address} "+
            "where userName = #{userName}"
            )
    public void updateAccount(Account account);

    @Update("update account set " +
            "passWord = #{passWord} " +
            "where id = #{id}")
    public void updatePasswordById(HashMap map);

    @Select("select * from account where vip=0")
    public List<Account> findAllUsers();
}

