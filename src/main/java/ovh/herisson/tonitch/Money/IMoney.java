package ovh.herisson.tonitch.Money;

public interface IMoney {
    float money = 100.0F;

    float getMoney();
    void setMoney(float value);

    default void takeMoney(float value){
        this.setMoney(this.getMoney()-value);
    }

    default void giveMoney(float value){
        this.setMoney(this.getMoney()+value);
    }

}
