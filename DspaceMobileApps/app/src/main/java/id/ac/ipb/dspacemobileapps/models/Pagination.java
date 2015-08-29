package id.ac.ipb.dspacemobileapps.models;


/**
 * Created by Hanif Affandi Hartanto on 7/17/2015.
 */
public class Pagination {
    public static final String ORDER_BY_LAST_UPDATE = "last_update";
    public static final String ORDER_BY_NAME = "name";
    public static final String ORDER_BY_RATING = "rating";

    private Integer firstIndex;
    private Integer lastIndex;
    private Integer pageCurrent;
    private Integer pageCount;
    private Integer count;
    private String orderBy;

    public Integer getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(Integer firstIndex) {
        this.firstIndex = firstIndex;
    }

    public Integer getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(Integer lastIndex) {
        this.lastIndex = lastIndex;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
