package SegmentTree;
//tree节点中保存的值，如区间中最大值最小值，或者是和，乘积等
public interface Merger<E> {
    E merge(E a, E b);
}
