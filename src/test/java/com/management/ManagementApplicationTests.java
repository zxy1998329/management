package com.management;

import com.management.mapper.NoticeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class ManagementApplicationTests {

	@Autowired
	NoticeMapper noticeMapper;

	@Test
	void contextLoads() throws SQLException {
		System.out.println(noticeMapper.getNoticeById(3));
	}

}
