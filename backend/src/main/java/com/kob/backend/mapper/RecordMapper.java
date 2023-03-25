package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Steven
 * @create 2023-03-25-21:34
 */

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}
