package com.example.todoapi.common.enums;



public enum CompF {

    INCOMPLETE(0),

    COMPLETION(1),
    ;

    private int flag;

    private CompF(int flag) {
        this.flag = flag;
    }

    public int getCode() {
        return flag;
    }


    public static CompF toEnum(int flag) {

        for( CompF code : CompF.values() ) { //拡張for文による走査
            if( code.getCode() == flag ) {
                return code;                 //条件に一致するインスタンスを返す
            }
        }
        return null;
    }

}
