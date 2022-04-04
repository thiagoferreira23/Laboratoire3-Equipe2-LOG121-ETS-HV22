package Observers;

public interface MyObservable {

    public void addObservers(Observateur o);

    public void deleteObservers(Observateur o);

    public void notifyObservers();

}
