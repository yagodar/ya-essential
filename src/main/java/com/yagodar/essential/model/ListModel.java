package com.yagodar.essential.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yagodar on 24.06.2015.
 */
public class ListModel<T extends Model> extends Model {
    public ListModel(long id) {
        this(id, null);
    }

    public ListModel(long id, String defName) {
        this(id, defName, null);
    }

    public ListModel(long id, String defName, String name) {
        this(id, defName, name, null);
    }

    public ListModel(long id, String defName, String name, Integer modelCount) {
        super(id, defName, name);
        setModelCount(modelCount);
    }

    public int getCount() {
        if(isLoaded()) {
            return mModelList.size();
        } else if(isModelCountLoaded()) {
            return mModelCount;
        } else {
            throw new IllegalStateException("Nor model List no model count not loaded yet!");
        }
    }

    public List<T> getModelList() {
        ensure();
        return mModelList;
    }

    public void setModelList(List<T> modelList) {
        if(modelList == null) {
            throw new IllegalArgumentException("Model list must not be null!");
        }

        mModelList = modelList;

        mModelIdList = new LinkedList<>();
        for(T model : mModelList) {
            mModelIdList.add(model.getId());
        }
    }

    public boolean isLoaded() {
        return mModelList != null;
    }

    public void putModel(T model) {
        ensure();

        if(model == null) {
            throw new IllegalArgumentException("Model must not be null!");
        }

        long id = model.getId();
        int pos = mModelIdList.indexOf(id);
        if(pos != -1) {
            mModelList.set(pos, model);
        } else {
            mModelList.add(model);
            mModelIdList.add(id);
        }
    }

    public int getPos(long id) {
        ensure();
        return mModelIdList.indexOf(id);
    }

    public int getPos(T model) {
        ensure();
        if(model == null) {
            throw new IllegalArgumentException("Model must not be null!");
        }
        return mModelIdList.indexOf(model.getId());
    }

    public T getModel(long id) {
        ensure();

        int pos = mModelIdList.indexOf(id);
        if(pos != -1) {
            return mModelList.get(pos);
        } else {
            return null;
        }
    }

    public T getModel(int pos) {
        ensure();
        return mModelList.get(pos);
    }

    public boolean removeModel(long id) {
        ensure();
        int pos = mModelIdList.indexOf(id);
        if(pos != -1) {
            mModelList.remove(pos);
            mModelIdList.remove(pos);
            return true;
        } else {
            return false;
        }
    }

    protected void ensure() {
        if(!isLoaded()) {
            throw new IllegalStateException("Model List not loaded yet!");
        }
    }

    public boolean isModelCountLoaded() {
        return mModelCount != null;
    }

    private void setModelCount(Integer modelCount) {
        if(modelCount == null) {
            return;
        }
        if(modelCount < 0) {
            throw new IllegalArgumentException("Model count must not be < 0!");
        }
        mModelCount = modelCount;
    }

    private Integer mModelCount;
    private List<T> mModelList;
    private List<Long> mModelIdList;
}
