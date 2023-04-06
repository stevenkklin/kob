package com.kob.backend.controller.record;

import com.alibaba.fastjson.JSONObject;
import com.kob.backend.common.util.R;
import com.kob.backend.controller.form.record.GetRecordListDTO;
import com.kob.backend.service.record.GetRecordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author Steven
 * @create 2023-04-03-19:15
 */
@RestController
public class GetRecordListController {
    @Autowired
    private GetRecordListService getRecordListService;

    @GetMapping("/api/record/getList/{page}")
    public R getList(@PathVariable int page) {
        return R.ok("获取记录分页成功").put("list", getRecordListService.getList(page));
    }
}
