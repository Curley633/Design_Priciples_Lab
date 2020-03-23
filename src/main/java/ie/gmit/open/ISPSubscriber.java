package ie.gmit.open;

import java.util.List;

public class ISPSubscriber extends Subscriber {
    private long freeUsage;

    public ISPSubscriber( Long subscriberId, String address, Long phoneNumber, int baseRate, long freeUsage)
    {
        super();
    }

    public double calculateBill()
    {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(getSubscriberId());
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return chargeableData*getBaseRate()/100;
    }

    public long getFreeUsage()
    {
        return freeUsage;
    }

    public void setFreeUsage(long freeUsage)
    {
        this.freeUsage = freeUsage;
    }
}