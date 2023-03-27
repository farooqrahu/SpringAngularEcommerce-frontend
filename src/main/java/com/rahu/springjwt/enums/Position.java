/**
 * @author Junaid Butt
 * @email junaid.butt@ideatolife.me
 * @create date 2020-05-07 05:45:13
 * @modify date 2020-05-07 05:45:13
 * @desc [description]
 */
package com.rahu.springjwt.enums;

public enum Position {

    admin("admin"),
    user("user");

    public final String positionTitle;

    private Position(String positionTitle) {
        this.positionTitle = positionTitle;
    }
}
