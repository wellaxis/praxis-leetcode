package com.witalis.praxis.leetcode.task.h3.p278.content;

public final class VersionControl {
    private static int badVersion;

    private VersionControl() {
        super();
    }

    public static int getBadVersion() {
        return badVersion;
    }

    public static void setBadVersion(int badVersion) {
        VersionControl.badVersion = badVersion;
    }

    public static boolean isBadVersion(int version) {
        return version >= getBadVersion();
    }
}
