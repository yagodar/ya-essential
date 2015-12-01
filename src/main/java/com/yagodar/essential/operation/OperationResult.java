package com.yagodar.essential.operation;

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

    public OperationResult(Throwable failThrowable, D data) {
        this(null, null, failThrowable, data);
    }

    public OperationResult(String failMessage, D data) {
        this(failMessage, null, null, data);
    }

    public OperationResult(String failMessage, Throwable failThrowable, D data) {
        this(failMessage, 0, failThrowable, data);
    }

    public OperationResult(Integer failMessageId, D data) {
        this(null, failMessageId, null, data);
    }

    public OperationResult(Integer failMessageId, Throwable failThrowable, D data) {
        this(null, failMessageId, failThrowable, data);
    }

    public OperationResult(String failMessage, Integer failMessageId, Throwable failThrowable, D data) {
        mFailMessage = failMessage;
        mFailMessageId = failMessageId;
        mFailThrowable = failThrowable;
        mData = data;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode())
                + " FailMessage[" + mFailMessage + "]"
                + " FailMessageId[" + mFailMessageId + "]"
                + " FailThrowable[" + mFailThrowable + "]"
                + " Data[" + mData + "]";
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
