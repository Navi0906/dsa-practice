import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Analytics {
    enum ActionEnum{
        feature1Button,
        feature2Button,
        feature3Button
    }

    private AnalyticsStore store;
    private int k;
    private Queue<ActionEnum> actionQueue;
    private int totalActions;

    public Analytics(AnalyticsStore store, int k) {
        this.store = store;
        this.k = k;
        this.actionQueue = new LinkedList<>();
        this.totalActions = 0;
    }


    public void registerAction(ActionEnum action) {
        actionQueue.add(action);
        totalActions++;

        if(actionQueue.size() == k) {
            Queue<ActionEnum> actions = new LinkedList<>(actionQueue);
            store.storeActions(actions);
            actionQueue.clear();
        }
    }

    public int getNumberOfActionRegisteredButNotSentToAnalyticsStore(){
        return actionQueue.size();
    }

    public int getTotalNumberOfLoggedActions(){
        return totalActions;
    }

    public List<ActionEnum> getMostFrequentlyUsedActions(){
        List<ActionEnum> result = new ArrayList<>();
        int maxFreq = 0;

        for()

        return result;
    }


}

class AnalyticsStore{
    void storeActions(Queue<Analytics.ActionEnum> actions) {
        System.out.println("Stored "+actions.size()+" actions");
    }
}
