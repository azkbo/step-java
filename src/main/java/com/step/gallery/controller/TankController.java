package com.step.gallery.controller;

import com.step.gallery.entity.body.ActionBody;
import com.step.gallery.entity.dao.Action;
import com.step.gallery.entity.result.DataResult;

import com.step.gallery.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create By: Meng
 * Date: 202
 * Desc:
 */
@RestController
@RequestMapping("/player")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class TankController extends BaseController {
  @Autowired
  private TankService service;
  // 初始化
  @RequestMapping(value = "init", method = RequestMethod.POST)
  public DataResult gameInit() {
    return DataResult.succee(0);
  }

  // 获取坦克动作
  @RequestMapping(value = "action", method = RequestMethod.POST)
  public DataResult tankAction(@RequestBody() ActionBody body) {
    List<Action> list = service.tankAction(body);
    return DataResult.succee(list);
  }
}
