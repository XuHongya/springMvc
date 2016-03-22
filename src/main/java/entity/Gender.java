package entity;

/**
 * Created by Administrator on 2016/3/18.
 */
public enum  Gender {
    MAN("man"),WOMAN("woman");
    private final String value;

    Gender(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
