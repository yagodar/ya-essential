package com.yagodar.essential.factory;

/**
 * Created by yagodar on 06.12.2015.
 */
public class IdGroupIntFactory {
    public IdGroupIntFactory(int groupCount) {
        if(groupCount <= 0) {
            throw new IllegalArgumentException("Group count [" + groupCount + "] must be greater than 0!");
        }
        mGroupIdMask = ~0 >>> Integer.numberOfLeadingZeros(groupCount);
    }

    public int getGroupId(int itemId) {
        return itemId & mGroupIdMask;
    }

    public int getNextItemId(int itemId) {
        return itemId + mGroupIdMask + 1;
    }

    private final int mGroupIdMask;
}
