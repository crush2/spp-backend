package com.example.spp_backend.task;

import com.example.spp_backend.entity.Curriculum;
import com.example.spp_backend.repository.CurriculumRepository;
import com.example.spp_backend.service.CurriculumService;
import com.example.spp_backend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class WarnTask {
    @Autowired
    private MailService mailService;
    @Autowired
    private CurriculumService curriculumService;
    @Autowired
    private CurriculumRepository curriculumRepository;

    /**
     * 表示每天执行两次
     * 0 0 7,22 * * *
     */
    @Scheduled(cron = "0 0 7,22 * * *") private void sendWarningMail(){
        String subject = "洪山科普平台课程提醒";
        List<Curriculum> tommorrowCurriculumList = curriculumService.getTommorrowCurriculumList();
        for(Curriculum curriculum : tommorrowCurriculumList){
            String to = curriculum.getTeacherEmail();
            String techerName = curriculum.getTeacher();
            String curriculumName = curriculum.getName();
            String startTime = curriculum.getTime().toString();
            String content = "尊敬的" + techerName
                    + ",由您主讲的《" +curriculumName
                    + "》课程将在" + startTime
                    + "（明天）开始，请您提前安排好时间，做好准备。";
            mailService.sendEmail(to,"主讲课程提醒",content);
            System.out.println("发送定时邮件成功");

            Date now = new Date();
            curriculum.setWarnTime((Timestamp) now);
            curriculumRepository.save(curriculum);
        }

    }

}
