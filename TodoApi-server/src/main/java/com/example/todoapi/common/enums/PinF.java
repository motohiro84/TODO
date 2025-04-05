package com.example.todoapi.common.enums;



public enum PinF {

    NO_PIN(0),

    PINNED(1),
    ;

    private int flag;

    private PinF(int flag) {
        this.flag = flag;
    }

    public int getCode() {
        return flag;
    }


    public static PinF toEnum(int flag) {

        for( PinF code : PinF.values() ) { //拡張for文による走査
            if( code.getCode() == flag ) {
                return code;                 //条件に一致するインスタンスを返す
            }
        }
        return null;
    }

}
