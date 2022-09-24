package com.step.gallery.controller;

import com.google.gson.Gson;
import com.step.gallery.modules.error.AppException;
import com.step.gallery.modules.error.EnumError;
import com.step.gallery.entity.result.DataResult;
import com.step.gallery.entity.scene.Scene;
import com.step.gallery.service.socket.SocketSession;
import com.step.gallery.utils.TextUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@RestController
@RequestMapping("/robot/scene")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class SceneController extends BaseController {

  // 完成通知
  @RequestMapping(value = "complete", method = RequestMethod.GET)
  public DataResult complete(@RequestParam("sceneId") String sceneId, @RequestParam("actionId") String actionId,
      @RequestParam("uid") String uid) throws Exception {
        System.out.println("scene============>scene:");
    // 报错
    if (TextUtils.isEmpty(sceneId) || TextUtils.isEmpty(sceneId) || TextUtils.isEmpty(uid)) {
      throw AppException.create(EnumError.NOT_PARAM_ERROR);
    }
    
    WebSocketSession session = SocketSession.instance().get(uid);
    if(session != null) {
      DataResult result = DataResult.succee(actionId);
      Gson gson = new Gson();
      TextMessage msg = new TextMessage(gson.toJson(result));
      session.sendMessage(msg);
      return DataResult.succee("成功");
    }
    return DataResult.create(EnumError.NOT_UID_ERROR);
  }

  // 根据获取文字回去场景id
  @RequestMapping(value = "getSceneId", method = RequestMethod.GET)
  public DataResult getScene(@RequestParam("text") String scene, @RequestParam("token") String token) {

    return DataResult.succee(scene);
  }

  // 根据场景id获取场景对话
  @RequestMapping(value = "getActions", method = RequestMethod.GET)
  public DataResult getActions(@RequestParam("sceneId") String sceneId, @RequestParam("token") String token) {
    
    // 根据场景获取对应的参数
    Scene scene2 = Scene.getScene(sceneId, token);

    return DataResult.succee(scene2);
  }
}
