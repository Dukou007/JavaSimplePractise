package com.huaqin.domain1;

import java.io.Serializable;

public class QueryVo implements Serializable {

    private User user;

    public QueryVo() {
    }

    public QueryVo(User user) {

        this.user = user;
    }
}
