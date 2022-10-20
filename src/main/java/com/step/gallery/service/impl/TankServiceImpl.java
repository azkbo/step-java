package com.step.gallery.service.impl;

import com.step.gallery.entity.body.ActionBody;
import com.step.gallery.entity.dao.Action;
import com.step.gallery.modules.game.TankGame;
import com.step.gallery.service.TankService;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Author: Meng
 * Date: 2022-10-19
 * Desc:
 */
@Service
public class TankServiceImpl implements TankService {

  @Override
  public String gameInit() {
    return "OK";
  }

  @Override
  public List<Action> tankAction(ActionBody body) {
    return TankGame.getTankActions(body);
  }


}
