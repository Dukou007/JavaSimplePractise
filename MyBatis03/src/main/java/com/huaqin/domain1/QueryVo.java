package com.huaqin.domain1;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable {

    private User user;
    private List<Integer> ids;


    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                ", ids=" + ids +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
