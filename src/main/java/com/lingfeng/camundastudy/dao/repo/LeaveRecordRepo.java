package com.lingfeng.camundastudy.dao.repo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingfeng.camundastudy.dao.mapper.LeaveRecordMapper;
import com.lingfeng.camundastudy.domain.entity.LeaveRecordEntity;
import org.springframework.stereotype.Repository;

@Repository
public class LeaveRecordRepo extends ServiceImpl<LeaveRecordMapper, LeaveRecordEntity> {
}
