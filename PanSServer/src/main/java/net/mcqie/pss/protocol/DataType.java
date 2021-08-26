package net.mcqie.pss.protocol;/*
 * @author by MCqie
 *@date 2021/8/12.
 */

public enum DataType {

    account(1),
    connect(0),
    message(2),
    beat(3);
    private final int code;
    DataType(int code) {
        this.code=code;
    }
    @Override
    public String toString(){
        return this.code+"";
    }

    public int getCode() {
        return code;
    }
}
