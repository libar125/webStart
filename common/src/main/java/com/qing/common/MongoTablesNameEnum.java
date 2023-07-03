package com.qing.common;

/**
 * mongodb 的表名
 */
public enum MongoTablesNameEnum {

    IM_CONVERSATION("im_conversation","临时会话表"),

    USER_GROUP("user_group","用户群组表"),
    TEMP_USER_GROUP("temp_user_group","临时用户群组表"),

    USER_FRIENDS("user_friends","用户好友表"),

    USER_CARD("user_card","圈子名片"),

    FRIEND_CIRCLE_TIME_LINE("friend_circle_time_line","朋友圈时间线表"),
    FRIEND_CIRCLE_THUMBS_UP("friend_circle_thumbs_up","朋友圈点赞表"),
    FRIEND_CIRCLE_COMMENT("friend_circle_comment","朋友圈评论表"),

    NOTICE_INFO("notice_info","消息通知"),

    REPORT("report","举报表"),

    GROUP_DRAGONS("group_dragons","群接龙"),

    HORN_MESSAGES("horn_messages","喔呵帖子"),
    HORN_MESSAGE_STATS("horn_message_stats","喔呵帖子统计"),
    HORN_MESSAGE_THUMBS_UP("horn_message_thumbs_up","喔呵帖子统计"),

    END("end","最后一个");


    private final String tableName;

    private final String desc;

    MongoTablesNameEnum(String tableName, String desc) {
        this.tableName = tableName;
        this.desc = desc;
    }

    public String tableName() {
        return this.tableName;
    }


    public String desc() {
        return this.desc;
    }
}
