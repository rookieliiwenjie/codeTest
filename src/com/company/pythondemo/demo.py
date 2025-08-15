# -*- coding: utf-8 -*-
from graphviz import Digraph

# 创建思维导图
dot = Digraph(comment="位运算在算法中的应用", format="png")
dot.attr(rankdir="LR", size="8,6")

# 中心节点
dot.node("位运算", shape="ellipse", style="filled", color="lightblue")

# 一级分类
categories = [
    "状态压缩", "奇偶判断", "乘除2的幂", "位掩码操作",
    "数学运算优化", "统计1的个数", "低位操作", "子集枚举",
    "并查集压缩", "图论加速", "判断2的幂", "哈希映射",
    "滑动窗口状态", "加密压缩"
]

for cat in categories:
    dot.node(cat, shape="box", style="filled", color="lightyellow")
    dot.edge("位运算", cat)

# 二级细分
details = {
    "状态压缩": ["子集枚举", "TSP动态规划"],
    "奇偶判断": ["n & 1"],
    "乘除2的幂": ["n << k 乘法", "n >> k 除法"],
    "位掩码操作": ["取第k位", "设置第k位", "清除第k位", "翻转第k位"],
    "数学运算优化": ["mid = (l+r)>>1", "绝对值计算", "异或交换"],
    "统计1的个数": ["n & (n-1)"],
    "低位操作": ["n & -n（lowbit）"],
    "子集枚举": ["(sub-1) & mask"],
    "并查集压缩": ["位存储多个状态"],
    "图论加速": ["bitset邻接矩阵"],
    "判断2的幂": ["(n & (n-1)) == 0"],
    "哈希映射": ["(x<<shift)|y"],
    "滑动窗口状态": ["移位更新窗口"],
    "加密压缩": ["Base64", "Huffman"]
}

for cat, sublist in details.items():
    for sub in sublist:
        dot.node("{}_{}".format(cat, sub), sub, shape="note", style="filled", color="white")
        dot.edge(cat, "{}_{}".format(cat, sub))


# 输出图片
dot.render("bitwise_algorithms_map", cleanup=True)

print("思维导图已生成：bitwise_algorithms_map.png")
