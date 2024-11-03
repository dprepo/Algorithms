package dp.LB.Algo;

public class LBMain {
    public static void main(String[] args) {
    	loadBalance();
    }

    public static void loadBalance() {
        doGetServer(new RoundRobin());
        doGetServer(new RandomLoadBalance());
        doGetServer(new IpHash());
        doGetServer(new WeightRoundRobin());
        doGetServer(new WeightRandom());
    }


    public static void doGetServer(LoadBalance loadBalance) {
        doGetServer(loadBalance, 50);
    }

    private static void doGetServer(LoadBalance loadBalance, int queryTimes) {
        for (int i = 0; i < queryTimes; i++) {
            String serverId = loadBalance.getServer(String.valueOf(i));
            System.out.println(String.format("[%s] index:%s,%s", loadBalance.getClass().getSimpleName(), i, serverId));
        }
    }
}
