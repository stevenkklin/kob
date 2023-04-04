package com.kob.backend.service.ranklist;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Steven
 * @create 2023-04-04-15:00
 */
public interface GetRankListService {
    JSONObject getList(Integer page);
}
