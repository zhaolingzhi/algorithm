package template.list;

import java.util.Random;

public class Skiplist {
    class SkiplistLevel{
        SkiplistNode forward;
        int span;
    }

    class SkiplistNode{
        int val;
        SkiplistNode backward;
        SkiplistLevel[] level;
        public SkiplistNode(){
            this(0, MAX_LEVEL);
        }
        public SkiplistNode(int val){
            this(val, MAX_LEVEL);
        }
        public SkiplistNode(int val, int l){
            this.val = val;
            this.level = new SkiplistLevel[l];
            for (int i = 0; i < l; i++){
                this.level[i] = new SkiplistLevel();
            }
        }
    }
    static final int MAX_LEVEL = 8;

    SkiplistNode head;
    SkiplistNode tail;
    int length;
    int level;

    public Skiplist() {
        level = 1;
        length = 0;
        head = new SkiplistNode();
    }

    private SkiplistNode searchForPos(int target, SkiplistNode[] last){
        SkiplistNode pos = head;
        int l = MAX_LEVEL - 1;
        while(l != 0 || (pos.level[l].forward != null && pos.level[l].forward.val < target)){
            if(l != 0 && (pos.level[l].forward == null || pos.level[l].forward.val >= target)){
                last[l] = pos;
                l --;
            }else if(pos.level[l].forward != null && pos.level[l].forward.val < target){
                pos = pos.level[l].forward;
            }
        }
        last[0] = pos;
        return pos;
    }

    public boolean search(int target) {
        SkiplistNode[] last = new SkiplistNode[MAX_LEVEL];
        SkiplistNode pos = searchForPos(target, last);
        if(pos.level[0].forward == null) return false;
        return pos.level[0].forward.val == target;
    }

    public void add(int num) {
        SkiplistNode[] last = new SkiplistNode[MAX_LEVEL];
        SkiplistNode pos = searchForPos(num, last);

        Random rand = new Random();
        int randLevel = 1;
        while(randLevel < MAX_LEVEL && rand.nextDouble() < 0.5){
            randLevel ++;
        }

        SkiplistNode newNode = new SkiplistNode(num, randLevel);

        // TODO update span
        for(int i = 0; i < randLevel; i++){
            newNode.level[i].forward = last[i].level[i].forward;
            last[i].level[i].forward = newNode;
        }
        newNode.backward = pos;

    }

    public boolean erase(int num) {
        SkiplistNode[] last = new SkiplistNode[MAX_LEVEL];
        SkiplistNode pos = searchForPos(num, last);
        SkiplistNode nextPos = pos.level[0].forward;
        if(nextPos == null || nextPos.val != num){
            return false;
        }
        // TODO update span
        for(int i = 0; i < nextPos.level.length; i++){
            last[i].level[i].forward = nextPos.level[i].forward;
        }
        return true;
    }

    public static void main(String[] args) {
        Skiplist list = new Skiplist();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.search(0));;
        list.add(4);
        System.out.println(list.search(1));;
        list.erase(0);
        list.erase(1);
        System.out.println(list.search(1));;

    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
