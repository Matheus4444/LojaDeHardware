package br.edu.iff.bsi.LojaDeHardware.entities;

public enum TipoPecaEnum {
	CABO_DE_REDE(1),
    CPU(2),
    PLACA_MAE(3),
    GABINETE(4);

    private final int code;

    private TipoPecaEnum(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoPecaEnum toEnum(int code){
        for(TipoPecaEnum f : TipoPecaEnum.values()){
            if(f.getCode() == code){
                return f;
            }
        }
        return null;
    }
}
