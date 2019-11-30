package src.com.greed;

import java.util.ArrayList;
import java.util.Comparator;

public class Test2 {

    // 背包价值问题
    public static void main(String[] args) {
        TagObject tagObject1 = new TagObject(35, 10, 1);
        TagObject tagObject2 = new TagObject(30, 40, 2);
        TagObject tagObject3 = new TagObject(60, 30, 3);
        TagObject tagObject4 = new TagObject(50, 50, 4);
        TagObject tagObject5 = new TagObject(40, 35, 5);
        TagObject tagObject6 = new TagObject(10, 40, 6);
        TagObject tagObject7 = new TagObject(25, 30, 7);

        TagObject[] objects = {tagObject1, tagObject2, tagObject3, tagObject4, tagObject5, tagObject6, tagObject7};

        int totalWeight = 150;

        int maxWeight = 0;
        int maxPrice = 0;

        ArrayList<TagObject> list =  new ArrayList<>();
        list.add(tagObject1);
        list.add(tagObject2);
        list.add(tagObject3);
        list.add(tagObject4);
        list.add(tagObject5);
        list.add(tagObject6);
        list.add(tagObject7);
//        list.sort(new Comparator<TagObject>() {
//            @Override
//            public int compare(TagObject o1, TagObject o2) {
//                if (o1.price >= o2.price) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });

        System.out.println("---------------");

        ArrayList<TagObject> retArr = new ArrayList<>();

        while (totalWeight >= 0) {
//            TagObject o = chooseTagObj1(list);
//            TagObject o = chooseTagObj2(list);
            TagObject o = chooseTagObj3(list);
            if (o == null) break;
            
            if (totalWeight - o.weight >= 0) {
                o.status = 1;
                maxWeight += o.weight;
                maxPrice += o.price;
                totalWeight -= o.weight;
                retArr.add(o);
            } else {
                o.status = 2;
            }
        }

        for (TagObject obj : retArr) {
            if (obj.status == 1) {
                System.out.println("-------Tag--------" + obj.tag);
            }
        }
        System.out.println("-------MaxWeight--------" + maxWeight);
        System.out.println("-------MaxPrice--------" + maxPrice);
    }

    public static TagObject chooseTagObj1(ArrayList<TagObject> list) { //价格高优先
        TagObject ret = null;
        int max_price = 0;
        //在objs[i].status == 0的物品里，遍历挑选objs[i].price最大的物品
        for (TagObject o : list) {
            if (o.status == 0 && o.price > max_price) {//objs没有被选,并且price> max_price
                max_price = o.price;
                ret = o;
            }
        }
        return ret;
    }

    public static TagObject chooseTagObj2(ArrayList<TagObject> list) { //价格小优先
        TagObject ret = null;
        int max_price = 10000;
        //在objs[i].status == 0的物品里，遍历挑选objs[i].price最大的物品
        for (TagObject o : list) {
            if (o.status == 0 && o.weight < max_price) {//objs没有被选,并且price> max_price
                max_price = o.weight;
                ret = o;
            }
        }
        return ret;
    }

    public static TagObject chooseTagObj3(ArrayList<TagObject> list) { //价值密度高优先
        TagObject ret = null;
        double max_si = 0;
        //在objs[i].status == 0的物品里，遍历挑选objs[i].price最大的物品
        for (TagObject o : list) {
            if (o.status == 0) {//objs没有被选,并且price> max_price
                double si = (double) o.price / o.weight;
                if (si > max_si) {
                    max_si = si;
                    ret = o;
                }
            }
        }
        return ret;
    }
}
