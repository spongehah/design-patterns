package com.itheima.pattern.chainhandler2;

public class Manager extends Handler{

    public Manager() {
        super(NUM_ONE, NUM_THREE);
    }
    
    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天，" + leave.getContent() + "。");
        System.out.println("部门经理审批：同意");
    }
}
