package template.math;

public class 计算二进制有多少1 {
    public int count(int v){
        int cnt = 0;
        while(v != 0){
            cnt ++;
            v = v & (v - 1);
        }
        return cnt;
    }
}
