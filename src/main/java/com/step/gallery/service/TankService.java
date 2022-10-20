package com.step.gallery.service;

import com.step.gallery.entity.body.ActionBody;
import com.step.gallery.entity.dao.Action;
import java.util.List;
/**
 * Author: Meng
 * Date: 2022-10-19
 * Desc:
 */
public interface TankService {
  String gameInit();
  List<Action> tankAction(ActionBody body);
}
