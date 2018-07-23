package com.huaqin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Puke {


    public static void main(String[] args) {
        ArrayList<String> hua = new ArrayList<>();
        ArrayList<String> dian = new ArrayList<>();
        Collections.addAll(hua, "♠", "♥", "♣", "♦");
        Collections.addAll(dian, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        HashMap<Integer, String> map = new HashMap<>();
        int key = 1;
        map.put(key++, "大王");
        map.put(key++, "小王");
        for (String d : dian) {
            for (String h : hua) {
                map.put(key++, h + d);
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());

        List<Integer> p1key = new ArrayList<>();
        List<Integer> p2key = new ArrayList<>();
        List<Integer> p3key = new ArrayList<>();
        List<Integer> dpkey = new ArrayList<>();

        Collections.shuffle(keys);
        for (int i = 0; i < keys.size(); i++) {
            Integer k = keys.get(i);

            if (i >= 51) {
                dpkey.add(k);
            } else {
                if (i % 3 == 0) {
                    p1key.add(k);
                } else if (i % 3 == 1) {
                    p2key.add(k);
                } else {
                    p3key.add(k);
                }
            }


            Collections.sort(p1key);
            Collections.sort(p2key);
            Collections.sort(p3key);
            Collections.sort(dpkey);
            //12:根据玩家手中的序号,兑换成对应的牌
            List<String> p1value = new ArrayList<String>();
            List<String> p2value = new ArrayList<String>();
            List<String> p3value = new ArrayList<String>();
            List<String> dpvalue = new ArrayList<String>();
            for (Integer pk : p1key) {
                //根据pk的值,从map中获取对应的牌
                String v = map.get(pk);
                p1value.add(v);
            }
            for (Integer pk : p2key) {
                //根据pk的值,从map中获取对应的牌
                String v = map.get(pk);
                p2value.add(v);
            }
            for (Integer pk : p3key) {
                //根据pk的值,从map中获取对应的牌
                String v = map.get(pk);
                p3value.add(v);
            }
            for (Integer pk : dpkey) {
                //根据pk的值,从map中获取对应的牌
                String v = map.get(pk);
                dpvalue.add(v);
            }
            System.err.println("[玩家1]:" + p1value);
            System.err.println("[玩家2]:" + p2value);
            System.err.println("[玩家3]:" + p3value);
            System.err.println("[底牌]:" + dpvalue);
        }
    }
}