public class Time {
    private int second = 0;
    private int minute = 0;
    private int hour = 0;

    public Time(){}

    public Time(int second, int minute, int hour){
        setTime(second,minute,hour);
    }

    public void setSecond(int second) {
        if(second < 0 || second > 59){
            throw new IllegalArgumentException("minute must be between 0 and 59");
        }
        this.second = second;
    }
    
    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        if(hour < 0 || hour > 23){
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        if(minute < 0 || minute > 59){
            throw new IllegalArgumentException("minute must be between 0 and 59");
        }
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    public void setTime(int second, int minute, int hour){
        setHour(hour);
        setSecond(second);
        setMinute(minute);
    }

    public Time nextSecond(){
        this.second++;
        if(this.second == 60){
            this.second=0;
            this.minute++;
            if(this.minute == 60){
                this.minute = 0;
                this.hour++;
                if(this.hour == 24){
                    this.hour = 0;
                }
            }
        }
        return this;
    }

    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d", hour,minute,second);
    }
}
