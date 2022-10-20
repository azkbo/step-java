package com.step.gallery.entity.body;
import java.util.List;

/**
 * Create By: Meng
 * Create Date: 2022-10-19
 * 地图元素枚举	描述
 M1	            路
 M2	            复活币
 M3	            迷雾
 M4	            障碍物1
 M...	          障碍物...
 A1	            BOSS
 B1	            B队K2黑豹（攻击强）
 B2	            B队T-90（防守强）
 B3	            B队阿马塔（移动快）
 B4	            B队阿马塔（移动快）
 B5	            B队99主战坦克（射程远）
 C1	            C队K2黑豹（攻击强）
 C2	            C队T-90（防守强）
 C3	            C队阿马塔（移动快）
 C4	            C队阿马塔（移动快）
 C5	            C队99主战坦克（射程远）
 */
public class ActionBody {
    public TeamBody tA;
    public TeamBody tB;
    public TeamBody tC;
    public MapData view;
    public String team;
    public int glod;
    public int extend;

    public static class MapData {
        public String name;
        public int rowLen;
        public int colLen;
        public String[][] map;
    }

    public static class TeamBody {
        public String name; // 队伍名称
        public int glod; // 复活币
        public int extend; // 增益
        public List<TankBody> tanks; // 队伍
    }
}
