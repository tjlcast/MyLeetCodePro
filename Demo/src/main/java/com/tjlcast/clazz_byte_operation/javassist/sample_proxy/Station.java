package com.tjlcast.clazz_byte_operation.javassist.sample_proxy;

/**
 * @author by tangjialiang
 *         时间 2019/5/23.
 *         说明 ...
 */
public class Station implements TicketService {
    @Override
    public void sellTicket() {
        System.out.println("\n\t售票.....\n");
    }

    @Override
    public void inquire() {
        System.out.println("\n\t问询。。。。\n");
    }

    @Override
    public void withdraw() {
        System.out.println("\n\t退票......\n");
    }
}
