package com.itheima.pattern.chainhandler2;

public abstract class Handler {
    
    protected static final int NUM_ONE = 1;
    protected static final int NUM_THREE = 3;
    protected static final int NUM_SEVEN = 7;
    
    private int numStart;
    private int numEnd;
    
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    protected abstract void handleLeave(LeaveRequest leave);
    
    public final void submit(LeaveRequest leave) {
        if (leave.getNum() <= this.numEnd) {
            this.handleLeave(leave);
        } else if (this.nextHandler != null && leave.getNum() > this.numEnd) {
            this.nextHandler.submit(leave);
        } else {
            System.out.println("流程结束！");
        }
    }
}
