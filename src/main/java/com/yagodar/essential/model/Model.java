package com.yagodar.essential.model;

/**
 * Created by yagodar on 24.06.2015.
 */
public class Model {

    public Model(long id, String defName) {
        this(id, defName, null);
    }

    public Model(long id, String defName, String name) {
        if(defName == null) {
            throw new IllegalArgumentException("Default model name must not be null!");
        }

        mId = id;
        mDefName = defName;
        setName(name);
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public boolean setName(String name) {
        if(name == null || name.isEmpty()) {
            name = mDefName + "#" + mId;
        }

        boolean changed = false;

        if(mName == null || !name.equals(mName)) {
            mName = name;
            changed = true;
        }

        return changed;
    }

    private final long mId;
    private final String mDefName;
    private String mName;

}
