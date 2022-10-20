package com.step.gallery.modules.game;

import com.step.gallery.entity.body.ActionBody;
import com.step.gallery.entity.body.TankBody;
import com.step.gallery.entity.dao.Action;
import com.step.gallery.entity.dao.Point;

import java.util.*;

/**
 * Author: Meng
 * Date: 2022-10-19
 * Desc:
 */
public class TankGame {

    /**
     * 坦克数据处理
     */
    public static List<Action> getTankActions(ActionBody body) {
        List<Action> actions = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        String team = body.team; // 当前队伍名
        String teamChar = team.substring(1, 2); // 当前队伍字母 A,B,C
        int glod = 0; // 当前队伍金币
        List<TankBody> tanks = null; // 当前队伍
        if (team.equals("tB")) {
            glod = body.tB.glod;
            tanks = body.tB.tanks;
        } else {
            glod = body.tC.glod;
            tanks = body.tC.tanks;
        }

        int map_y = body.view.rowLen; // 行
        int map_x = body.view.colLen; // 列

        String[][] map = body.view.map; // M1-路/M3-迷雾/M2-复活币A1-boss
        Map<String, Point> all_point = new HashMap<String, Point>(); // 所有可见物体
        Map<String, Point> all_tags = new HashMap<String, Point>(); // 所有可攻击物体
        Map<String, Point> visuals = new HashMap<String, Point>(); // 随机视野盲区

        try {
            for (int i = map.length - 1; i >= 0; i--) {
                String[] list = map[i];
                for (int x = 0; x < list.length; x++) {
                    String key = list[x];
                    // 过滤 路|雾
                    if (!key.equals("M1") && !key.equals("M3")) {
                        int role = getTagRole(key, teamChar);
                        Point point = new Point(x, map_y - i, key, role);
                        if (role < 1) {
                            for (TankBody tank : tanks) {
                                if (tank.tId.equals(key)) {
                                    tank.lng = point.lng;
                                }
                            }
                        } else if (role > 1) {
                            all_tags.put(point.lng, point);
                        }
                        all_point.put(point.lng, point);
                    } else if (key.equals("M3")) {
                        Point point = new Point(x, map_y - i, key, -1);
                        visuals.put(point.lng, point);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("getTankActions Exception1: ");
            e.printStackTrace();
        }

        boolean hasTag = all_tags.size() > 0;
        try {
            if (hasTag) {

            } else {
                for (TankBody tank : tanks) {
                    Point tankPoint = all_point.get(tank.lng);
                    Point tag = findBastTag(tankPoint, visuals);

                    // 有目标
                    if (tag != null) {
                        // 最合适的路线
                        int[] line = getBestLine(tank, tag, all_point);
                        Action act = getAction(tank.tId, line, false);
                        actions.add(act);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("getTankActions Exception2: ");
            e.printStackTrace();
        }

        System.out.println("total use time: " + (System.currentTimeMillis() - startTime));
        return actions;
    }

    /**
     * 获取最近目标
     */
    private static Point findBastTag(
            Point point,
            Map<String, Point> tags
    ) {
        int min_dist = 1000000; // 最小距离
        Point tagPoint = null; // 目标物
        // 寻找视野目标
        boolean minNum = tags.size() < 10;
        Set<String> keys = tags.keySet();
        for (String key : keys) {
            Point tag = tags.get(key);
            if (!point.id.equals(tag.id) && (minNum || !tag.sign)) {
                int distance = pointDistance(point, tag);
                if (min_dist >= distance) {
                    min_dist = distance;
                    tagPoint = tag;
                }
            }
        }
        return tagPoint;
    }

    /**
     * 最合适的路线
     */
    private static int[] getBestLine(
            TankBody tank,
            Point tag,
            Map<String, Point> points
    ) {
        Point tankLng = points.get(tank.lng); // 当前坦克位置
        int[] orients = fromPointGetOrient(tankLng, tag);

        int yidong = tank.yidong;
        int gongji = tank.gongji;

        int[] tag_orient = new int[]{0, 0}; // [方向, 步数]

        for (int m = 0; m < orients.length; m++) {
            int ori = orients[m];
            // 对应方向的相对距离
            int gapNum = Math.abs(ori < 2 ? tankLng.y - tag.y : tankLng.x - tag.x);
            int stepNum = 0;
            boolean hasBarrier = false;
            int count = Math.min(gapNum, yidong); // 本次最大移动距离

            for (int i = 1; i <= count; i++) {
                String key = getPointkey(ori, tankLng);
                if (points.containsKey(key) && tag.role < 4) {
                    hasBarrier = true;
                    // break;
                }
                if (!hasBarrier) {
                    stepNum = i;
                }
            }
            // stepNum > 0 即为最佳
            if (stepNum > 0 && tag_orient.length < 1) {
                tag_orient = new int[]{ori, stepNum};
                return tag_orient;
            }
        }
        return tag_orient;
    }

    /**
     * 创建坦克操作策略
     */
    private static Action getAction(String tId, int[] line, boolean attack) {
        // 最合适的路线
        int typ = 1;
        int len = 0;
        String[] action_orient = new String[]{"UP", "DOWN", "LEFT", "RIGHT", "WAIT"};
        String[] action_type = new String[]{"MOVE", "FIRE"};
        String orient = action_orient[(int) Math.round(Math.random() * 4)];
        if (line.length > 0) {
            typ = 0;
            len = line[1];
            orient = action_orient[line[0]];
        }
        typ = attack ? 1 : typ;
        return new Action(tId, action_type[typ], len, orient);
    }

    /**
     * 获取目标 x,y坐标象限获取最佳运动方向 0上↑；1下↓；2左←；3右→；4停
     */
    private static int[] fromPointGetOrient(Point lng, Point lng2) {
        Point lng3 = new Point(lng2.x - lng.x, lng2.y - lng.y); // 相对位置坐标点
        int location = pointLocation(lng3.x, lng3.y);
        // 遇到障碍物 如果方向是在是坐标轴上，则优先在垂直坐标轴方向移动，非坐标轴则在x,y方向随机
        switch (location) {
            case 1:
                return new int[]{0, 3, 2, 1}; // [0, 3];
            case 2:
                return new int[]{0, 2, 3, 1}; // [0, 2];
            case 3:
                return new int[]{1, 2, 0, 3}; // [1, 2];
            case 4:
                return new int[]{1, 3, 2, 0}; // [1, 3];
            case 5:
                return new int[]{3, 1, 2, 0}; // [3];
            case 6:
                return new int[]{0, 3, 1, 2}; // [0];
            case 7:
                return new int[]{2, 0, 1, 3}; // [2];
            default:
                return new int[]{1, 2, 3, 0}; // [1];
        }
    }

    // 是否是可用移动范围 (朝向 0上↑；1下↓；2左←；3右→)
    private static String getPointkey(int orient, Point tag) {
        int x = tag.x;
        int y = tag.y;
        StringBuilder lngKey = new StringBuilder();
        switch (orient) {
            case 0:
            case 1:
                lngKey.append(x);
                lngKey.append(",");
                lngKey.append(y + (orient == 0 ? -1 : 1));
            case 2:
            case 3:
                lngKey.append(x + (orient == 2 ? -1 : 1));
                lngKey.append(",");
                lngKey.append(y);
            default:
                lngKey.append(x);
                lngKey.append(",");
                lngKey.append(y);
        }
        return lngKey.toString();
    }

    /**
     * 获取角色 // 类型 0队友；1障碍物；2敌方；3BOSS；4复活币
     */
    private static int getTagRole(String key, String str) {
        int role = 2;
        if (key.equals("M2")) {
            role = 4;
        } else if (key.contains("M")) {
            role = 1;
        } else if (key.contains("A")) {
            role = 3;
        } else if (key.contains(str)) {
            role = 0;
        }
        return role;
    }

    /**
     * 1象限一；2象限二；3象限三；4象限四；5x轴正；6y轴正；7x轴负；8y轴负
     */
    private static int pointLocation(int x, int y) {
        int qua = 1;
        if (x > 0) {
            qua = y > 0 ? 1 : y < 0 ? 4 : 5;
        } else if (x == 0) {
            qua = y > 0 ? 6 : 8;
        } else {
            qua = y > 0 ? 2 : y < 0 ? 3 : 7;
        }
        return qua;
    }

    /**
     * 获取两点之间的距离
     */
    private static int pointDistance(Point lng, Point lng2) {
        int x = lng2.x - lng.x;
        int y = lng2.y - lng.y;
        return x * x + y * y;
    }

}
