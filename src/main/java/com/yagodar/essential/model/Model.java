package com.yagodar.essential.model;

/**
 * Created by yagodar on 24.06.2015.
 */
public class Model {
    public Model(long id) {
        this(id, null);
    }

    public Model(long id, String defName) {
        this(id, defName, null);
    }

    public Model(long id, String defName, String name) {
        mId = id;
        setDefName(defName);
        setName(name);
        mTag = createTag();
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public boolean setName(String name) {
        if(name == null || name.length() == 0) {
            name = mDefName;
        }

        boolean changed = false;

        if(mName == null || !name.equals(mName)) {
            mName = name;
            changed = true;
        }

        return changed;
    }

    public Object getTag() {
        return mTag;
    }

    protected Object createTag() {
        return null;
    }

    private void setDefName(String defName) {
        if(defName == null) {
            mDefName = "#" + mId;
        } else {
            mDefName = defName + '#' + mId;
        }
    }

    private final long mId;
    private String mDefName;
    private String mName;
    private Object mTag;

}
