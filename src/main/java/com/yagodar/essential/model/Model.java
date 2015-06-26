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

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            mName = mDefName + "#" + mId;
        } else {
            mName = name;
        }
    }

    private final long mId;
    private final String mDefName;
    private String mName;

}
