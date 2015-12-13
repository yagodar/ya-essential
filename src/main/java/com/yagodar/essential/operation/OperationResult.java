package com.yagodar.essential.operation;

import com.yagodar.essential.debug.DebugUtils;

/**
 * Created by yagodar on 19.06.2015.
 */
public class OperationResult<D> {

    public OperationResult() {
        this(null, null, null, null);
    }

    public OperationResult(D data) {
        this(null, null, null, data);
    }

    protected OperationResult(String failMessage, Integer failMessageId, Throwable failThrowable, D data) {
        mFailMessage = failMessage;
        mFailMessageId = failMessageId;
        mFailThrowable = failThrowable;
        mData = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DebugUtils.buildShortClassTag(this, sb);
        if (isSuccessful()) {
            sb.append(" success=ok");
        } else {
            sb.append(" success={");
            sb.append("'").append(getFailMessage());
            sb.append("' '").append(getFailMessageId());
            sb.append("' '").append(getFailThrowable());
            sb.append("'}");
        }
        sb.append(" data=").append(getData());
        sb.append("}");
        return sb.toString();
    }

    public boolean isSuccessful() {
        return mFailMessage == null && mFailMessageId == null && mFailThrowable == null;
    }

    public String getFailMessage() {
        return mFailMessage;
    }

    public void setFailMessage(String message) {
        mFailMessage = message;
    }

    public Integer getFailMessageId() {
        return mFailMessageId;
    }

    public void setFailMessageId(Integer messageId) {
        mFailMessageId = messageId;
    }

    public Throwable getFailThrowable() {
        return mFailThrowable;
    }

    public void setFailThrowable(Throwable throwable) {
        mFailThrowable = throwable;
    }

    public D getData() {
        return mData;
    }

    public void setData(D data) {
        mData = data;
    }

    private String mFailMessage;
    private Integer mFailMessageId;
    private Throwable mFailThrowable;
    private D mData;
}
