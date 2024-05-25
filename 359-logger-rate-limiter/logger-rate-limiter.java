class Logger {
    private HashMap<String, Integer> messageFreetimeMap;

    public Logger() {
        this.messageFreetimeMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (this.messageFreetimeMap.containsKey(message)) {
            if (timestamp >= this.messageFreetimeMap.get(message)) {
                this.messageFreetimeMap.put(message, timestamp + 10);
                return true;
            } else {
                return false;
            }
        } else {
            this.messageFreetimeMap.put(message, timestamp + 10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */