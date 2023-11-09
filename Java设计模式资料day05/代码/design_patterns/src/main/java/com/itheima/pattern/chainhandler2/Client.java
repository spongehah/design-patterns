package com.itheima.pattern.chainhandler2;

public class Client {

    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest("张三", 9, "生病");

        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();
        
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);
        
        groupLeader.submit(leaveRequest);
    }
}
