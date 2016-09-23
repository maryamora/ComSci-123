//Code Created By: Hernandez, Amora

public class BoatRide implements Chargeable, Comparable<BoatRide> {
  private double baseFare;
  private double distance;
  
  public BoatRide(double baseFare, double distance) {
    this.baseFare = baseFare;
    this.distance = distance;
  }
  
  public void setBaseFare(){
    this.baseFare = baseFare;
  }
  
   public void setDistance(){
    this.distance = distance;
  }
  
  public double getBaseFare(){
    return this.baseFare;
  }
  
  public double getDistance(){
    return distance;
  }
  
  public double cost() {
    return baseFare * distance;
  }
  
  public int compareTo(BoatRide o) {
    return baseFare > o.baseFare ? 1 : (baseFare < o.baseFare ? -1 : 0);
  }
  
  public String toString(){
  return String.format("%.1f, %.1f",baseFare,distance);
  }
}

// IS-A