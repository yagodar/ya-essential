package com.yagodar.essential.operation;

/**
 * Created by yagodar on 11.12.2015.
 */
public class OperationArgsResult<A, D> extends OperationResult<D> {
    public OperationArgsResult() {
        super();
    }

    public OperationArgsResult(D data) {
        super(data);
    }

    public OperationArgsResult(A args, D data) {
        super(data);
        mArgs = args;
    }

    protected OperationArgsResult(A args, String failMessage, Integer failMessageId, Throwable failThrowable, D data) {
        super(failMessage, failMessageId, failThrowable, data);
        mArgs = args;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.insert(sb.indexOf(" "), " args=" + getArgs());
        return sb.toString();
    }

    public A getArgs() {
        return mArgs;
    }

    public void setArgs(A args) {
        mArgs = args;
    }

    private A mArgs;
}
