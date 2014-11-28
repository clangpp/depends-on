package com.clangpp.depends_on.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Defines table and column names for checklist database.
 */
public class ChecklistContact {

    public static final String CONTENT_AUTHORITY = "com.clangpp.depends_on";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_ITEM = "item";
    public static final String PATH_DEPENDENCY = "dependency";

    /**
     * Checklist item column names in database.
     */
    public static final class ItemEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ITEM).build();
        public static final String TABLE_NAME = "item";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_DESCRIPTION = "description";
    }

    /**
     * Checklist item dependency database.
     */
    public static final class DependencyEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_DEPENDENCY).build();
        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_DEPENDS = "depends";
        public static final String COLUMN_TRIGGERS = "triggers";
    }
}
