package com.management.mapper;

import com.management.entity.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("select * from notice")
    public List<Notice> getAll();

    @Select("select * from notice where id = #{id}")
    public Notice getNoticeById(Integer id);

    @Update("update notice set " +
            "publishDate=#{publishDate},title=#{title},content=#{content} " +
            "where id = #{id}")
    public void updateNoticeById(Notice notice);

    @Insert("insert into notice(ownerId,publishDate,title,content) " +
            "values(#{ownerId},#{publishDate},#{title},#{content})")
    public void insertNotice(Notice notice);

    @Delete("delete from notice where id = #{id}")
    public void deleteNoticeById(Integer id);
}
