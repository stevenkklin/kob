package com.kob.backend.controller.ranklist;

import com.kob.backend.common.util.R;
import com.kob.backend.service.ranklist.GetRankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.kob.backend.common.util.R.ok;

/**
 * @author Steven
 * @create 2023-04-04-15:03
 */
@RestController
public class GetRankListController {

    @Autowired
    private GetRankListService getRankListService;

    @GetMapping("/rankList/getList/{page}")
    public R getList(@PathVariable int page) {
        return R.ok("获取排行榜列表成功").put("list",getRankListService.getList(page));
    }
}
