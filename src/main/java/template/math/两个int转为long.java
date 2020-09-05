package template.math;

public class 两个int转为long {
    int[] long2Pos(Long v){
        int[] p = new int[2];
        p[0] = (int)(v >> 32);
        p[1] = (int)(v & 0xffffffff);
        return p;
    }

    Long pos2Long(int x, int y){
        Long v = 0L;
        v += (long)x << 32;
        v += y;
        return v;
    }
}
