package com.management.controller.mian;

import com.management.entity.Notice;
import com.management.entity.Pay;
import com.management.mapper.NoticeMapper;
import com.management.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomepageController {
    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    PayMapper payMapper;

    @RequestMapping(value="homepage",produces = "test/json;charset=UTF-8")
    public String get(HttpSession session, Model model){
        Integer id = (Integer)session.getAttribute("id");
        Set arrears = new HashSet();
        Pay pay = payMapper.getPayById(id);
        if((int)pay.getWater()<0){
            arrears.add("水费余额不足，请缴费！");
        }
        if((int)pay.getElectric()<0){
            arrears.add("电费余额不足，请缴费！");
        }
        if((int)pay.getGas()<0){
            arrears.add("气费余额不足，请缴费！");
        }
        if((int)pay.getManage()<0){
            arrears.add("物管费余额不足，请缴费！");
        }
        model.addAttribute("arrears",arrears);

        //获取公告
        List<Notice> notices = noticeMapper.getAll();
        model.addAttribute("notices",notices);
        return "index";
    }
}
