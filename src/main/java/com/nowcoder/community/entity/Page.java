package com.nowcoder.community.entity;

/**
 * 封装分页的工具类
 */
public class Page {

    // 当前页数
    private int current = 1;

    // 默认的一页最大数据数量
    private int limit = 10;

    // 数据总条数
    private int rows;

    //查询路径
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取当前页起始行
    public int getOffset(){
        return current * limit - limit;
    }

    public int getTotal(){
        int total;
        if (rows % limit == 0){
            total = rows / limit;
        }
        else total = rows / limit + 1;
        return total;
    }

    public int getFrom(){
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        to = to > total ? total : to;
//        System.out.println("to:" + to + "total:" + total + "current:" + current);
        return to;
    }


}
