
package moisoft;


public class ModelMoi 
{
    private String name;
    private String place;
    private float amount;

    public ModelMoi(String name, String place, float amount) {
        this.name = name;
        this.place = place;
        this.amount = amount;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    
    
}
