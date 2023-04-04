package com.kob.backend.service.record;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Steven
 * @create 2023-04-03-19:08
 */
public interface GetRecordListService {
    JSONObject getList(Integer page);
}
