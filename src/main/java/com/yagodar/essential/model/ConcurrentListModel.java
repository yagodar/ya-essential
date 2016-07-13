package com.yagodar.essential.model;

import java.util.List;

/**
 * Created by yagodar on 24.06.2015.
 */
public class ConcurrentListModel<T extends Model> extends ListModel<T> {
    public ConcurrentListModel(long id) {
        super(id);
    }

    public ConcurrentListModel(long id, String defName) {
        super(id, defName);
    }

    public ConcurrentListModel(long id, String defName, String name) {
        super(id, defName, name);
    }

    @Override
    public synchronized List<T> getModelList() {
        return super.getModelList();
    }

    @Override
    public synchronized int getCount() {
        return super.getCount();
    }

    @Override
    public synchronized void setModelList(List<T> modelList) {
        super.setModelList(modelList);
    }

    @Override
    public synchronized boolean isLoaded() {
        return super.isLoaded();
    }

    @Override
    public synchronized void putModel(T model) {
        super.putModel(model);
    }

    @Override
    public synchronized T getModel(long id) {
        return super.getModel(id);
    }

    @Override
    public synchronized T getModel(int pos) {
        return super.getModel(pos);
    }

    @Override
    public synchronized boolean removeModel(long id) {
        return super.removeModel(id);
    }

}
